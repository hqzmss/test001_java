package com.hqzmss.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class LambdaTest {

    @Test
     void test() {
        new Thread(() -> {
            System.out.println("中华人民共和国");
            System.out.println("123");
        });
    }

    @Test
    void test2() {
        func(() -> System.out.println("345"));
    }

    private void func(IFunction function) {
         function.test();
    }

    @Test
    void testHasParam() {
        funcHasParam(System.out::println);

        Runnable runnable = () -> System.out.println("890");
        System.out.println(runnable);
    }

    private void funcHasParam(IFunctionParam functionParam) {
        functionParam.test(3);
    }

    @Test
    void testList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        //old way
        for(Integer n : list) {
            System.out.println(n);
        }

        list.forEach(System.out::println);
    }

    @Test
    void testForEach() {
        List<String> list = Arrays.asList("123", "456", "jfkew", "中华人民共和国");

        list.forEach(System.out::println);
    }

    @Test
    void testPredicate() {
        List<String> languages = Arrays.asList("Java", "C++", "PHP", "html", "JavaScript", "CSS");
        filter(languages, s -> s.startsWith("J"));

        filter(languages, s -> true);

        filter(languages, s -> false);
    }

    private void filter(List<String> list, Predicate<String> predicate) {
        list.stream().filter(predicate).map(name -> "name=" + name).forEach(System.out::println);
    }
}
