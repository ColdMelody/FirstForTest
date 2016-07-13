package AnnotationDemo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Bill on 2016/7/13.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
    enum Priority {LOW, MEDIUM, HIGH}

    enum Status {STARTED, NOT_STARTED}

    String author() default "Yash";

    Priority priority() default Priority.LOW;

    Status status() default Status.NOT_STARTED;
}
