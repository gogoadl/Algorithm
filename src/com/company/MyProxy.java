package com.company;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class MyProxy implements InvocationHandler {
    private Object target;

    public MyProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 원하는 메서드가 호출되었을 때 추가 작업을 수행합니다.
        long start = 0;
        long end = 0;
        if (method.isAnnotationPresent(PerformanceTest.class)) {
            start = System.currentTimeMillis();
        }

        // 원본 메서드를 호출합니다.
        Object result = method.invoke(target, args);

        // 원하는 메서드가 호출된 후 추가 작업을 수행합니다.
        if (method.isAnnotationPresent(PerformanceTest.class)) {
            end = System.currentTimeMillis();
        }

        System.out.println(String.format("함수 실행에 %dms 만큼 소요 되었습니다.", end-start));

        return result;
    }
}
