package ReflectionTest.hight;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //权限修饰符
            int modifiers = declaredField.getModifiers();//0为缺省，1为public,2为private，4为protect
            System.out.print(Modifier.toString(modifiers)+"  ");
            //数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type+" ");
            //变量名
            String name = declaredField.getName();
            System.out.println(name);

        }
    }
}
