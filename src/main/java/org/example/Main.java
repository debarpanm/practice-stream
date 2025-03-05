package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        //**filter** *Question:* Fetch all numbers from a list that are greater than 5.
        List<Integer> filterList = List.of(1, 2, 5, 6, 7);
        System.out.println(filterList.stream().filter(num -> num > 5).toList());

        //**map** *Question:* Transform a list of strings into a list of their uppercase versions
        List<String> mapList = List.of("Apple", "Bat", "Cat");
        System.out.println(mapList.stream().map(String::toUpperCase).collect(Collectors.toList()));

        //**flatMap** *Question:* Given a list of lists of strings, flatten them into a single list of strings.
        List<List<String>> flatmapList = List.of(List.of("A", "B", "C"), List.of("D", "E", "F"));
        System.out.println(flatmapList.stream().flatMap(Collection::stream).collect(Collectors.toList()));

        //**distinct** *Question:* Remove duplicates from a list of integers.
        List<Integer> distinctList = List.of(1, 1, 2, 3, 3, 3, 4, 5, 5);
        System.out.println(distinctList.stream().distinct().collect(Collectors.toList()));

        //**sorted** *Question:* Sort a list of names in reverse alphabetical order.
        List<String> sortedList = List.of("Apple", "Bat", "Cat");
        System.out.println(sortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //**peek** *Question:* Print each element in a list while converting them to uppercase.
        //This method exists mainly to support debugging, where you want to see the elements as they flow past a certain point in a pipeline
        List<String> peekList = List.of("Apple", "Bat", "Cat");
        peekList.stream().peek(System.out::println).map(String::toUpperCase).toList();

        //**limit** *Question:* Fetch the first 3 elements from a list of integers.
        List<Integer> limitList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(limitList.stream().limit(3).collect(Collectors.toList()));

        //**skip** *Question:* Skip the first 4 elements and fetch the remaining elements from a list of integers.
        List<Integer> skipList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(skipList.stream().skip(4).collect(Collectors.toList()));


        //**forEach** *Question:* Print each element of a list of strings with a prefix "Item: ".
        List<String> forEachList = List.of("Apple", "Banana", "Mango");
        forEachList.forEach(fruit -> System.out.println("Item: " + fruit));

        //**collect** *Question:* Collect a list of integers into a Set.
        List<Integer> collectList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(collectList.stream().collect(Collectors.toSet()));

        //Print Duplicate numbers
        List<Integer> numberListWithDuplicateValues = List.of(1, 2, 3, 4, 5, 6, 3, 3, 5);
        Set<Integer> duplicates = new HashSet<>();
        System.out.println(numberListWithDuplicateValues.stream().filter(n -> !duplicates.add(n)).collect(Collectors.toSet()));

        //Find repeatation of each word
        String s = "He is good boy boy";
        String[] list = s.split(" ");
        System.out.println(Arrays.stream(list).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //2) How do you remove duplicate elements from a list using Java 8 streams?
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        System.out.println(listOfStrings.stream().distinct().collect(Collectors.toList()));

        //3) How do you find frequency of each character in a string using Java 8 streams?
        String inputString = "Java Concept Of The Day";
        System.out.println(Arrays.stream(inputString.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //4) How do you find frequency of each element in an array or a list?
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        System.out.println(stationeryList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //5) How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        System.out.println(decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));

        //6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        List<String> listOfMedias = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");
        System.out.println(listOfMedias.stream().collect(Collectors.joining(",", "[", "]")));

        //7) From the given list of integers, print the numbers which are multiples of 5?
        List<Integer> listOfIntegers1 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(listOfIntegers1.stream().filter(n -> n % 5 == 0).collect(Collectors.toList()));

        //8) Given a list of integers, find maximum and minimum of those numbers?
        List<Integer> listOfIntegers2 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println(listOfIntegers2.stream().max(Comparator.naturalOrder()).get());
        System.out.println(listOfIntegers2.stream().min(Comparator.naturalOrder()).get());

        //9) How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        int[] arr1 = new int[]{5, 3, 1};
        int[] arr2 = new int[]{4, 2};
        int[] c = IntStream.concat(Arrays.stream(arr1), Arrays.stream(arr2)).sorted().toArray();
        System.out.println(Arrays.toString(c));

        //10) How do you merge two unsorted arrays into single sorted array without duplicates?
        int[] a = new int[]{4, 2, 5, 1};
        int[] b = new int[]{8, 1, 9, 5};
        int[] c1 = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().toArray();
        System.out.println(Arrays.toString(c1));

        //11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("Three Max Number : " + listOfIntegers.stream().sorted().limit(3).collect(Collectors.toList()));
        System.out.println("Three Min Number : " + listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()));

        //12) Java 8 program to check if two strings are anagrams or not?

        //13) Find sum of all digits of a number in Java 8?
        int i = 15623;
        System.out.println(Arrays.stream(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt)));

        //14) Find second-largest number in an integer array?
        List<Integer> listOfIntegers3 = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        System.out.println("Second Largest Number : " + listOfIntegers3.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        //15) Given a list of strings, sort them according to increasing order of their length?
        List<String> listOfStrings1 = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        System.out.println(listOfStrings1.stream().sorted(Comparator.comparing(String::length)));

        //16) Given an integer array, find sum and average of all elements?
        int[] d = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        System.out.println("Sum : " + Arrays.stream(d).sum());
        System.out.println("Average : " + Arrays.stream(d).average().getAsDouble());

        //18) Reverse each word of a string using Java 8 streams?
        String str = "Java Concept Of The Day";
        System.out.println(Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" ")));

        //19) How do you find sum of first 10 natural numbers?
        System.out.println(IntStream.iterate(1,n->n+1).limit(10).sum());

        //20) Reverse an integer array

        //21) Print first 10 even numbers
        System.out.println(IntStream.iterate(1,n->n+1).filter(j-> j%2 ==0).limit(10).boxed().toList());

        //22) How do you find the most repeated element in an array?

        //23) Palindrome program using Java 8 streams
        String str1 = "ROTATOR";
        System.out.println(str1 + " is Palindrome " + IntStream.range(0,str.length()/2).noneMatch(in -> str.charAt(in) != str.charAt(str.length() - in -1)));

        //24) Given a list of strings, find out those strings which start with a number?
        List<String> listOfStrings2 = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        System.out.println(listOfStrings2.stream().filter(st -> Character.isDigit(st.charAt(0))).collect(Collectors.toList()));

        //25) How do you extract duplicate elements from an array?
        List<Integer> listOfIntegers4 = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        Set<Integer> set = new HashSet<>();
        System.out.println(listOfIntegers4.stream().filter(num -> !set.add(num)).collect(Collectors.toSet()));

        //26) Print duplicate characters in a string?
        String inputString1 = "Java Concept Of The Day".replaceAll("\\s+", "").toLowerCase();
        Set<String> uniqueChars = new HashSet<>();
        System.out.println(Arrays.stream(inputString1.split("")).filter(ch -> !uniqueChars.add(ch)).collect(Collectors.toSet()));

        //27) Find first repeated character in a string?

        //28) Find first non-repeated character in a string?

        //29) Fibonacci series

        //30) First 10 odd numbers
        System.out.println(Stream.iterate(1, n->n+1).filter(num -> num%2 != 0).limit(10).toList());

        //31) How do you get last element of an array?
        List<String> listOfStrings3 = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
        System.out.println(listOfStrings3.stream().skip(listOfStrings3.size()-1).findFirst().get());

        //Check Prime Number
        int number = 29;
        System.out.println(number + " is Prime : " + IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(x -> number % x == 0));

        SolvingRealTimeQueries.print();
    }

}