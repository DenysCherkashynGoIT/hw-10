package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    public static List<String> persons = Arrays.asList("Ihor",         //1
                                                       "Polina",       //2
                                                       "Olexandr",     //3
                                                       "Olha",         //4
                                                       "Andriy",       //5
                                                       "Mykola",       //6
                                                       "Veronika",     //7
                                                       "Svitlana",     //8
                                                       "Serhii",       //9
                                                       "Marina",       //10
                                                       "Ivan");        //11

    public static void main(String[] args) {
        //-----------------------------------------------------------------------------------------------------------
        //    Задание 1#
        //    Метод принимает на вход список имен. Вернуть строку в виде: "1. Ivan, 3. Peter ...", с именами из списка,
        //    стоящими под нечетным индексом (1, 3 и т.д.).
        System.out.println("\n**********************************************************************************");
        System.out.println("Задание 1#\n");

        ListHandler listHandler = new ListHandler();
        System.out.println(listHandler.getOdd(persons));

        //-----------------------------------------------------------------------------------------------------------
        //    Задание 2#
        //    Метод принимает на вход список из строк (можно список из Задания 1). Возвращает список этих строк в
        //    верхнем регистре и отсортированные по убыванию (от Z до А).
        System.out.println("\n**********************************************************************************");
        System.out.println("Задание 2#\n");

        System.out.println(listHandler.toUpperCaseReversed(persons));

        //-----------------------------------------------------------------------------------------------------------
        //    Задание 3#
        //    Дан массив: ["1, 2, 0", "4, 5"]. Получить из массива все числа, вернуть в отсортированном виде,
        //    разделенные запятой, то есть "0, 1, 2, 4, 5"
        System.out.println("\n**********************************************************************************");
        System.out.println("Задание 3#\n");

        String[] numbers = new String[]{"1, 2, 0", "4, 5"};
        System.out.println(ArraySort.sort(numbers));

        //-----------------------------------------------------------------------------------------------------------
        //    Задание 4#
        //    Используя Stream.iterate сделайте бесконечный стрим рандомных чисел, но не используя Math.random.
        //    Реализуйте свой "линейный конгруэнтный генератор". Для этого начните с x[0] = seed и затем каждый
        //    следующий элемент x[n + 1] = 1 (a x[n] + c) % m, для корректных значений a, c, и m.
        //    Необходимо имплементировать метод, который принимает на вход параметры a, c, m и seed и возвращает
        //    Stream<Long>. Для теста используйте данные a = 25214903917, c = 11 и m = 2^48 (2 в степени 48).
        System.out.println("\n**********************************************************************************");
        System.out.println("Задание 4#\n");

        Random random = new Random();
        random.streamLong(25214903917L, 11, (long) Math.pow(2, 48), 0)
                .limit(10).map(String::valueOf).forEach(System.out::println);

        //-----------------------------------------------------------------------------------------------------------
        //    Задание 5#
        //    Напишите метод public static <T> Stream<T> zip(Stream<T> first, Stream<T> second),
        //    который "перемешивает" элементы из стримов first и second, останавливается тогда,
        //    когда у одного из стримов закончатся элементы.
        System.out.println("\n**********************************************************************************");
        System.out.println("Задание 5#\n");

        String result;

        String str1 = "Китайские ученые научились вызывать дождь при помощи звука";
        String str2 = "Вирусы герои бактериальных пандемий";
        Stream<String> stream1 = Arrays.stream(str1.split("\\s+"));
        Stream<String> stream2 = Arrays.stream(str2.split("\\s+"));
        result = StreamMixer.zip(stream1, stream2).collect(Collectors.joining(" "));
        System.out.println(result);

        Stream<Integer> stream3 = Stream.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19);
        Stream<Integer> stream4 = Stream.of(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40);
        result = StreamMixer.zip(stream3, stream4).map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
