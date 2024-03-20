package com.company;

import com.google.auto.service.AutoService;
import com.squareup.javapoet.MethodSpec;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;



public class PerformanceProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(PerformanceTest.class);
        for (Element element : elements) {
            Name elementName = element.getSimpleName();
            if (element.getKind() != ElementKind.INTERFACE) { // 엘리먼츠가 인터페이스가 아닐 경우 에러 출력
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                    "Magic annotation can not be used on " + elementName);
            } else {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing "+ elementName);
            }
            if (element.getKind() != ElementKind.METHOD) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                    "@Performance annotation can only be applied to methods", element);
                continue;
            }

            // Get the method name
            String methodName = element.getSimpleName().toString();

            // Get the fully qualified class name
            String className = ((TypeElement) element.getEnclosingElement()).getQualifiedName().toString();

            // Print a warning message
            processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                String.format("Method %s in class %s is annotated with @Performance", methodName, className));

            // Measure method execution time
            long startTime = System.nanoTime();
            try {
                // Execute the annotated method
                Object instance = Class.forName(className).newInstance();
                
                Object result1 = element.getSimpleName().toString();
                // Assuming the method has no parameters
                Object result = element.getEnclosingElement();
                // Print execution time
                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;
                processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                    String.format("Execution time of method %s in class %s: %d nanoseconds",
                        methodName, className, executionTime));
            } catch (Exception e) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
                    "Error occurred while measuring performance: " + e.getMessage(), element);
            }
        }

        return true;
    }
}
