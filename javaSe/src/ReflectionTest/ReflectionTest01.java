package ReflectionTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest01 {

    //反射前对Person的操作
    @Test
    public void test1() {
        //创建Person对象
        Person p1 = new Person("tonm", 11);
        //通过对象调用其内部属性和方法
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();

        //在Person类外部，不可以调用其内部私有结构。
    }

    @Test
    //对Person的反射操作
    public void test02() throws Exception {
        Class clazz = Person.class;
        //1.通过反射创建Person对象
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("tom", 12);
        Person p = (Person) obj;
        System.out.println(obj);
        //2.通过反射调用对象中指定的属性，方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);
        //调用对象中指定的方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);//执行show方法

        //3.通过反射调用对象中私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("tt");
        System.out.println(p1);
        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"Jack");
        System.out.println(p1);
        //私有方法
        Method showString = clazz.getDeclaredMethod("showString");
        showString.setAccessible(true);
        String ss =(String) showString.invoke(p1);
        System.out.println(ss);
    }

    @Test
    //获取Class实例的方式
    public void test03() throws ClassNotFoundException {
        //方式1：调用运行时类的属性.class
        Class<Person> clazz1 = Person.class;
        //方式2：通过运行时类的对象
        Person p = new Person();
        Class<? extends Person> clazz2 = p.getClass();
        //方式3：调用class的静态方法：forName(String classPath);
        Class<?> clazz3 = Class.forName("ReflectionTest.Person");

        System.out.println(clazz1==clazz2);//true
        System.out.println(clazz1==clazz3);//true

        //方式4：ClassLoader
        ClassLoader classLoader = ReflectionTest01.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("ReflectionTest.Person");
        System.out.println(clazz1==clazz4);//true
    }
}
