import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SwitchCaseEvolution {

    //Java switch case in jdk 7 - only integer value allowed
    public static void switchCaseJava7(int value) {
        switch (value) {
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                break;
            case 3:
                System.out.println("three");
                break;
            default:
                System.out.println("default");
        }
    }

    //Java switch case in jdk 8 - String and Enum value allowed
    public static void switchCaseWithStringValueJava8(String value) {
        switch (value) {
            case "one":
                System.out.println("one");
                break;
            case "two":
                System.out.println("two");
                break;
            case "three":
                System.out.println("three");
                break;
            default:
                System.out.println("default");
        }
    }

    //Java switch case in jdk 8 - String and Enum value allowed
    public static void switchCaseWithEnumValueJava8(NUMBERS value) {
        switch (value) {
            case ONE:
                System.out.println("one");
                break;
            case TWO:
                System.out.println("two");
                break;
            case THREE:
                System.out.println("three");
                break;
            default:
                System.out.println("default");
        }
    }

    enum NUMBERS {
        ONE, TWO, THREE
    }

    /*
     * Java switch case in jdk 12 -
     * return value using yield (jdk13)
     * return value using arrow function
     * multiple values in case level
     * */
    public static String switchCaseReturnsValueJava12(NUMBERS value) {
        return switch (value) {
            case ONE:
                yield "odd";
            case TWO:
                yield "even";
            case THREE:
                yield "odd";
        };
    }

    public static String switchCaseReturnsValueUsingArrowFunctionJava12(String value) {
        return switch (value) {
            case "one" -> "odd";
            case "two" -> "even";
            case "three" -> "odd";
            default -> "unknown";
        };
    }

    public static String switchCaseWithMultipleCaseReturnsValueJava12(String value) {
        return switch (value) {
            case "one", "three" -> "two odd value case";
            case "two" -> "one even value case";
            default -> "unknown";
        };
    }

    /*
     * Java switch case in jdk 17 -
     * pattern matching - match pattern in case level (pass object to case)
     * Guarded pattern
     * Null case
     * */
    public static String switchCaseWithObjectValueGuardedPatternJava17(Integer value) {
        return switch (value) {
            case Integer n && n.intValue()==1 -> "value is one";
            case Integer n && n.intValue()==2 -> "value is two";
            case Integer n && n.intValue()==3 -> "value is three";
            default -> "unknown value";
        };
    }

    public static String switchCaseReturnsValueWithNullCaseJava17(String value) {
        return switch (value) {
            case "non-null" -> "Non-null value";
            case null -> "Null value";
            default -> "unknown";
        };
    }


    public static void main(String[] args) {
        switchCaseJava7(2);
        switchCaseWithStringValueJava8("one");
        switchCaseWithEnumValueJava8(NUMBERS.THREE);
        System.out.println(switchCaseReturnsValueJava12(NUMBERS.ONE));
        System.out.println(switchCaseReturnsValueUsingArrowFunctionJava12("two"));
        System.out.println(switchCaseWithMultipleCaseReturnsValueJava12("one"));
        System.out.println(switchCaseWithObjectValueGuardedPatternJava17(Integer.valueOf(2)));
        System.out.println(switchCaseReturnsValueWithNullCaseJava17(null));
    }
}
