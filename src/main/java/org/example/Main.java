package org.example;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //**filter** *Question:* Fetch all numbers from a list that are greater than 5.
        List<Integer> filterList = List.of(1,2,5,6,7);
        System.out.println(filterList.stream().filter(num -> num>5).collect(Collectors.toList()));

        //**map** *Question:* Transform a list of strings into a list of their uppercase versions
        List<String> mapList = List.of("Apple","Bat","Cat");
        System.out.println(mapList.stream().map(String::toUpperCase).collect(Collectors.toList()));

        //**flatMap** *Question:* Given a list of lists of strings, flatten them into a single list of strings.
        List<List<String>> flatmapList = List.of(List.of("A","B","C"),List.of("D","E","F"));
        System.out.println(flatmapList.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        //**distinct** *Question:* Remove duplicates from a list of integers.
        List<Integer> distinctList = List.of(1,1,2,3,3,3,4,5,5);
        System.out.println(distinctList.stream().distinct().collect(Collectors.toList()));

        //**sorted** *Question:* Sort a list of names in reverse alphabetical order.
        List<String> sortedList = List.of("Apple","Bat","Cat");
        System.out.println(sortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //**peek** *Question:* Print each element in a list while converting them to uppercase.
        //This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline
        List<String> peekList = List.of("Apple","Bat","Cat");
        peekList.stream().peek(System.out::println).map(String::toUpperCase).collect(Collectors.toList());

        //**limit** *Question:* Fetch the first 3 elements from a list of integers.
        List<Integer> limitList = List.of(1,2,3,4,5,6);
        System.out.println(limitList.stream().limit(3).collect(Collectors.toList()));

        //**skip** *Question:* Skip the first 4 elements and fetch the remaining elements from a list of integers.
        List<Integer> skipList = List.of(1,2,3,4,5,6);
        System.out.println(skipList.stream().skip(4).collect(Collectors.toList()));



        //**forEach** *Question:* Print each element of a list of strings with a prefix "Item: ".
        List<String> forEachList = List.of("Apple","Banana","Mango");
        forEachList.forEach(fruit -> System.out.println("Item: " +fruit));

        //**collect** *Question:* Collect a list of integers into a Set.
        List<Integer> collectList = List.of(1,2,3,4,5,6);
        System.out.println(collectList.stream().collect(Collectors.toSet()));
        
    }
}