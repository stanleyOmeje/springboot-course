package com.stan.springbootcourse.annotations;

import lombok.Data;

@Looking
@Data
public class LookingClass {
    private String name = "Chidoz";

    public String getAnnotationName(String annotationName) {
        return annotationName;
    }

    @MethodAnnotation
    public void methodWithAnnotation(String annotationName) {
        System.out.println("I am annotated with "+ annotationName);
    }
}
