package ReflectionTest.hight;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ConstructorTest {
    @Test
    public void test1() {
        Class<Person> clazz = Person.class;
        //获取当前运行时类中，声明为public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        //获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }

    @Test
    public void test2() {
        Class<Person> clazz = Person.class;
        Class<? super Person> superclass = clazz.getSuperclass();
        System.out.println(superclass);

        //带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //获取泛型类型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0].getTypeName());
    }

    @Test
    public void test3() {
        Class<Person> clazz = Person.class;
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //获取运行时类的父类实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    @Test
    public void test4() {
        Class<Person> clazz = Person.class;
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    @Test
    public void test5() {
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}
