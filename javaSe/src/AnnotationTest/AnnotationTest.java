package AnnotationTest;

import java.lang.annotation.Annotation;

@MyAnnotation(value = "hello")
public class AnnotationTest {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 35; i++) {
            sb.append(1);
        }
        System.out.println(sb.capacity());
    }
}

class Inherited extends AnnotationTest{
    public static void main(String[] args) {
        Class clazz = Inherited.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
            //结果：@AnnotationTest.MyAnnotation(value=hello)
        }
    }
}
