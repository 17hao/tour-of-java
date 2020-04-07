package xyz.shiqihao.basic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Todo {
    public enum Priority {LOW, MEDIUM, HIGH}

    public enum Status {OPEN, IN_PROCESS, BLOCKED, IN_REVIEW, TESTING, CLOSED}

    String author();

    Priority priority();

    Status status();
}
