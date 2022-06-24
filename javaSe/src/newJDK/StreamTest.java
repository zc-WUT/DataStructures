package newJDK;


import iotest.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void test1() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张弛", 18));
        list.add(new Person("李四", 11));
        list.add(new Person("王五", 22));

        //default Stream<E> stream() {}; 返回一个顺序流
        Stream<Person> stream = list.stream();

        //default Stream<E> parallelStream() {}; 返回一个并行流
        Stream<Person> personStream = list.parallelStream();
    }

    @Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        //调用Arrays类的static <T> Stream<T>  stream(T[] arr){} 返回一个流
        IntStream stream = Arrays.stream(arr);

        Person person = new Person("张弛", 18);
        Person person1 = new Person("张三", 11);
        Person[] people = new Person[]{person, person1};
        Stream<Person> stream1 = Arrays.stream(people);
    }

    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void test4() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张弛", 18));
        Person lisi = new Person("李四", 11);
        list.add(lisi);
        list.add(lisi);
        list.add(new Person("王五", 22));
        list.add(new Person("张三", 485));

        Stream<Person> stream = list.stream();
        stream.filter(person -> person.getAge() > 10).limit(4).forEach(System.out::println);
        //stream.limit(3).forEach(System.out::println); 报错，因为此时stream已经关闭了
        System.out.println("======================");
        list.stream().skip(1).forEach(System.out::println);
        System.out.println("======================");
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void test5() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);//AA BB CC DD
    }

    @Test
    public void test6() {
        //读取长度大于2的名字
        List<Person> list = new ArrayList<>();
        list.add(new Person("张弛弛", 18));
        Person lisi = new Person("李四", 11);
        list.add(lisi);
        list.add(new Person("王五五", 22));
        list.add(new Person("张三", 485));
        Stream<String> nameStream = list.stream().map(Person::getName);
        nameStream.filter(name -> name.length() > 2).forEach(System.out::println);
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println("==========");
        Stream<Character> characterStream = list.stream().flatMap(StreamTest::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str) {
        List<Character> list = new ArrayList<>();
        for (char c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test8() {
        List<Integer> list1 = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list1.stream().sorted().forEach(System.out::println);
    }

    @Test
    public void test9() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张弛弛", 18));
        Person lisi = new Person("李四", 11);
        list.add(lisi);
        list.add(new Person("王五五", 22));
        list.add(new Person("张三", 485));
        boolean b = list.stream().allMatch(person -> person.getAge() > 10);
        System.out.println(b);

        boolean anyMatch = list.stream().anyMatch(person -> person.getAge() > 20);
        System.out.println(anyMatch);

        boolean noneMatch = list.stream().noneMatch(person -> person.getName().startsWith("张"));
        System.out.println(noneMatch);

        Optional<Person> first = list.stream().findFirst();
        System.out.println(first);

        Optional<Person> any = list.stream().findAny();
        System.out.println(any);
    }


    @Test
    public void test10() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张弛弛", 18));
        Person lisi = new Person("李四", 11);
        list.add(lisi);
        list.add(new Person("王五五", 22));
        list.add(new Person("张三", 485));
        //查询数量
        long count = list.stream().filter(person -> person.getAge() > 20).count();
        System.out.println(count);
        //查询最大值
        Stream<Integer> integerStream = list.stream().map(person -> person.getAge());
        Optional<Integer> max = integerStream.max(Integer::compareTo);
        System.out.println(max);
        //查询最小值
        Optional<Person> min = list.stream().min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));
        System.out.println(min);
    }

    @Test
    public void test11() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(1, Integer::sum);//结果是 1+Integer::sum=56
        System.out.println(reduce);
    }


    @Test
    public void test12() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("张弛弛", 18));
        Person lisi = new Person("李四", 11);
        list.add(lisi);
        list.add(new Person("王五五", 22));
        list.add(new Person("张三", 485));
        List<Person> collect = list.stream().filter(person -> person.getAge() > 20).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test13() {
        Person person=new Person("11",1);
        person=null;
        //Optional<Person> person1 = Optional.of(person);//java.lang.NullPointerException
        Optional<Person> person1 = Optional.ofNullable(person);
        System.out.println(person1);
    }

    @Test
    public void test14(){
        List<Integer> list=Arrays.asList(23,43,45,55,61,54,32,2,45,89,7);

    }
}
