package com.stan.springbootcourse.annotations;

import com.stan.springbootcourse.dto.request.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        LookingClass lookingClass = new LookingClass();
        if (lookingClass.getClass().isAnnotationPresent(Looking.class)) {
            lookingClass.setName("Chidozie");
            String annotationName = lookingClass.getClass().getAnnotation(Looking.class).name();
            System.out.println("Annotated class name is "+annotationName);
            System.out.println("LookingClass name is "+lookingClass.getName());
        }else {
            System.out.println(lookingClass.getClass() + " is not annotated with @Looking");
        }
        System.out.println("----------------------------------------------------------");

        for (Method method : lookingClass.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodAnnotation.class)) {
                String annotationName = method.getDeclaredAnnotation(MethodAnnotation.class).value();
                System.out.println("Method name is "+method.getName());
                System.out.println(method.invoke(lookingClass,annotationName));
                System.out.println("#####################################3");
            }
        }
        System.out.println("12345".matches("\\d+"));
        System.out.println("=====================================");
        Student student = new Student();
        student.setPhone("1234567890a");
        System.out.println(student.getPhone());

    }
}
