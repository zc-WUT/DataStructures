package ReflectionTest.hight;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionT {

    @Test
    public void test2() throws Exception {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "张三");
        System.out.println(name.get(person));
    }

    @Test
    public void test3() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String chn = (String) show.invoke(p, "chn");
        System.out.println(chn);

        //静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.invoke(clazz);
    }

    @Test
    public void test4() throws Exception {
        Class<Person> clazz = Person.class;
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person tom = declaredConstructor.newInstance("Tom");
        System.out.println(tom);
    }
}
