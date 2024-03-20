package com.company;


import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Algorithm
public class Main {
    static {
        // 클래스가 로드될 때 실행되는 코드
        AnnotationProcessor annotationProcessor = new AnnotationProcessor();
        annotationProcessor.findAnnotatedMethods(Main.class);
    }
    @PerformanceTest(type = TimeType.TIME_MILLISEC)
    void run() {
        int j = 0;
        for (int i = 0; i < 1000000; i++) {
            j++;
        }

    }
    public static void main(String[] args) {
//        Main main = new Main();

        Main main1 = (Main) Proxy.newProxyInstance(Main.class.getClassLoader(),
            new Class[]{Main.class},
            new MyProxy(new Main()));
        main1.run();


    }
    static class AnnotationProcessor {
        public void findAnnotatedMethods(Class<?> clazz) {
            // 클래스의 모든 메서드를 가져옵니다.
            Method[] methods = clazz.getDeclaredMethods();

            // 각 메서드에 대해 어노테이션을 확인합니다.
            for (Method method : methods) {
                // 메서드에 붙은 모든 어노테이션을 가져옵니다.
                Annotation[] annotations = method.getDeclaredAnnotations();
                for (Annotation annotation : annotations) {
                    // 원하는 어노테이션이 있는지 확인합니다.
                    if (annotation instanceof PerformanceTest) {
                        // 해당 어노테이션이 붙은 메서드의 정보를 출력합니다.
                        System.out.println("Method with annotation found: " + method.getName());

                        try {
                            long start = System.currentTimeMillis();

                            // 어노테이션이 있는 메서드를 호출합니다.
                            method.invoke(clazz.newInstance());

                            long end = System.currentTimeMillis();

                            // 어노테이션이 있는 메서드를 호출한 후에 실행되는 코드
                            System.out.println(String.format("함수 실행에 %dms 만큼 소요 되었습니다.", end-start));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break; // 어노테이션이 발견되면 반복문 종료
                    }
                }
            }
        }
    }

}
