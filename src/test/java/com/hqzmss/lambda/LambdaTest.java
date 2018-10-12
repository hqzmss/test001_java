package com.hqzmss.lambda;

import org.junit.jupiter.api.Test;

class LambdaTest {
    private static void test(int x) {
        System.out.println("x=" + x);
    }

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
        /*funcHasParam(new IFunctionParam() {
            @Override
            public void test(int x) {
                System.out.println("x=" + x);
            }
        });*/

        funcHasParam(LambdaTest::test);
    }

    private void funcHasParam(IFunctionParam functionParam) {
        functionParam.test(3);
    }
}
