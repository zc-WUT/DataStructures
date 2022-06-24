package ReflectionTest.hight;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            //获取方法上注解
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.print(annotation);
            }

            //获取权限修饰符
            int modifiers = method.getModifiers();
            System.out.print(Modifier.toString(modifiers)+" ");

            //获取返回值类型
            System.out.print(method.getReturnType().getName()+" ");

            //方法名
            System.out.print(method.getName()+"(");

            //形参列表
            Class<?>[] parameterTypes = method.getParameterTypes();
            if (!(parameterTypes==null&&parameterTypes.length==0)){
                for (int i=0;i<parameterTypes.length;i++) {
                    System.out.print(parameterTypes[i].getName()+"args_"+i+" ");
                }
            }
            System.out.print(")");

            //获取抛出的异常
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length>0){
                System.out.print("throws");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getName()+" ");
                }
            }
            System.out.println();
        }
    }
}
