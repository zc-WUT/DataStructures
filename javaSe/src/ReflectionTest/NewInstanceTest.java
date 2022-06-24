package ReflectionTest;

import org.junit.Test;

public class NewInstanceTest {
    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;
        /**
         * instance():调用此方法，创建对应的运行时类的对象
         * 内部调用了运行时类的空参构造器
         */
        Person person = clazz.newInstance();
    }
}
