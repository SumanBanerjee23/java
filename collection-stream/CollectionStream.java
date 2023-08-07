import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionStream {

    //Java program to count the occurrence of each character in a text
    public static void findCharacterOccurrenceInText(String text) {
        Map<String, Long> result = Arrays.stream(text.split(""))
                                         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);
    }

    //Java program to find all duplicate characters from a given text
    public static void findDuplicateCharactersInText(String text) {
        List<String> result = Arrays.stream(text.split(""))
                                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                                    .entrySet()
                                    .stream()
                                    .filter(entry -> entry.getValue() > 1)
                                    .map(Map.Entry::getKey)
                                    .collect(Collectors.toList());
        System.out.println(result);
    }

    //Java program to find first non repeat characters from a given text
    public static void findFirstNonRepeatCharactersInText(String text) {
        String result = Arrays.stream(text.split(""))
                           .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                           .entrySet()
                           .stream()
                           .filter(entry -> entry.getValue() == 1)
                           .findFirst().get().getKey();
        System.out.println(result);
    }

    //Java program to print a given array with comma delimiter
    public static <T> String printArrayWithCommaDelimiter(T[] numbers) {
        return Arrays.stream(numbers)
                     .map(Object::toString)
                     .collect(Collectors.joining(","));
    }

    //Java program to find second-highest number from a given array
    public static void findSecondHighestNumberInArray(Integer[] numbers) {
        Integer result = Arrays.stream(numbers)
                                        .sorted(Comparator.reverseOrder())
                                        .skip(1)
                                        .findFirst().get();
        System.out.println(result);
    }

    //Java program to find the longest text in a given array of texts
    public static void findLongestTextInArray(String[] texts) {
        String result = Arrays.stream(texts)
                              .reduce((text1, text2) -> text1.length() > text2.length() ? text1 : text2)
                              .get();
        System.out.println(result);
    }

    //Java program to find all the elements in an array that start with given character 'n'
    public static void findElementThatStartWithGivenCharacter(Integer[] numbers, Character c) {
        List<String> result = Arrays.stream(numbers)
                                     .map(Object::toString)
                                     .filter(text -> text.startsWith(c.toString()))
                                     .collect(Collectors.toList());
        System.out.println(result);
    }

    //Java program to print an array skipping first 'n' elements and till the 't' last element
    public static void printLimitedRangedArray(Integer[] numbers, int skip, int limit) {
        List<Integer> result = Arrays.stream(numbers)
                                      .skip(skip)
                                      .limit(limit)
                                      .collect(Collectors.toList());
        System.out.println(result);
    }

    public static void main(String[] args) {
        // Test cases
        String text = "welcometotheamazingworldofjava";
        Integer[] numbers = {11,23,35,4,15,26};
        Character n = '1';
        String[] texts = {"welcome", "to", "the", "amazing", "world", "of", "java"};
        int skip = 1;
        int limit = 4;
        System.out.println("text : " + text);
        System.out.println("count the occurrence of each character in a text : " + text);
        findCharacterOccurrenceInText(text);
        System.out.println("find all duplicate characters from a given text : " + text);
        findDuplicateCharactersInText(text);
        System.out.println("find first non repeat characters from a given text : " + text);
        findFirstNonRepeatCharactersInText(text);
        System.out.println("find second highest number from a given array : "
                + printArrayWithCommaDelimiter(numbers));
        findSecondHighestNumberInArray(numbers);
        System.out.println("find the longest text in a given array of texts : "
                + printArrayWithCommaDelimiter(texts));
        findLongestTextInArray(texts);
        System.out.println("find all the elements in an array : " + printArrayWithCommaDelimiter(numbers)
                + " that start with given character 'n' : " + n);
        findElementThatStartWithGivenCharacter(numbers, n);
        System.out.printf("print all the elements of an array : %s in the limited range," +
                " skipping first %d th elements and limiting till %d th element %n",
                printArrayWithCommaDelimiter(numbers), skip, limit);
        printLimitedRangedArray(numbers, skip, limit);
    }
}
