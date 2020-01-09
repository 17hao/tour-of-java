package xyz.shiqihao.basic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
public @interface MyAnnotation {
    public enum City {HANGZHOU, NINGBO}

    public enum Country {CHINA, JAPAN}

    City city() default City.HANGZHOU;

    Country country() default Country.CHINA;

    String author() default "sqh";
}
