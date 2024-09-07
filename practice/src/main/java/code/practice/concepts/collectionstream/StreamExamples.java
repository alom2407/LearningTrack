package code.practice.concepts.collectionstream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamExamples {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple","Anish","Alpana","Apun","salana");
        list.stream().filter(str->str.startsWith("A")).forEach(System.out::println);
    }
}
