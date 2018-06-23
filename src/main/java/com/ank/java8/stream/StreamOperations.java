package com.ank.java8.stream;

import com.ank.java8.common.Dish;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperations {

    public static void main(String args[]){

        long count = Dish.menu.stream()
                        .filter(d -> d.getCalories() >300)         // intermediate operation
                        .distinct()                              // intermediate operation
                        .limit(4)                              // intermediate operation
                        .count();                           // terminal operation

        System.out.println(count);


        /**
         * Creating 3 different streams variables as stream can be used only once.
         * */

        Stream<String> stringStream1 = Stream.of("Stream","of","Strings","generated","on","the","fly");
        Stream<String> stringStream2 = Stream.of("Stream","of","Strings","generated","on","the","fly");
        Stream<String> stringStream3 = Stream.of("Stream","of","Strings","generated","on","the","fly");

        stringStream1.forEach(System.out::println);

        List<String> list = stringStream2.collect(Collectors.toList());

        System.out.println(list); // [Stream, of, Strings, generated, on, the, fly]

        String concatenatedString = stringStream3.collect(Collectors.joining(" "));

        System.out.println(concatenatedString); // Stream of Strings generated on the fly
    }

}
