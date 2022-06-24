package Thread;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");
    }
    
}

interface Human {
    String getBelief();

    void eat(String food);
}

class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "我会飞";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class HumanUtil {
    public void method1() {
        System.out.println("通用方法1");
    }

    public void method2() {
        System.out.println("通用方法2");
    }
}

class ProxyFactory {
    //调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object object) {
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(object);

        Object o = Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), handler);
        return o;
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object object;//赋值时,需要使用被代理类的对象进行赋值

    public void bind(Object object) {
        this.object = object;
    }

    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    //将被代理类要执行的方法a的功能声明在invoke中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        HumanUtil humanUtil=new HumanUtil();
        humanUtil.method1();
        Object invoke = method.invoke(object, args);
        humanUtil.method2();
        return invoke;
    }
}

