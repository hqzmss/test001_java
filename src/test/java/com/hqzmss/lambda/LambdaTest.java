package com.hqzmss.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
