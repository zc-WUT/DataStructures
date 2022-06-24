package AnnotationTest;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

import static java.lang.annotation.ElementType.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
public @interface MyAnnotation {
    String value() default "1";
}
