package enumTest;

import java.util.*;
import java.util.concurrent.locks.LockSupport;

public class MakeTest {
    //自定义枚举类
    private String name;
    private int age;
    private MakeTest(String name,int age){
        this.name=name;
        this.age=age;
    }
    public static final MakeTest Zhang_San=new MakeTest("张三",3);
    public static final MakeTest Li_Si=new MakeTest("李四",4);
    public static final MakeTest Wang_Wu=new MakeTest("王五",5);

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    @Override
    public String toString() { return "MakeTest{" + "name='" + name + '\'' + ", age=" + age + '}'; }

    public static void main(String[] args) {
        Integer a=129;
        Integer b=129;
        System.out.println(a==b);
    }

}

enum MyTest  {
    ZhangSan("zhangchi",1), LiSi("李四",2),WangWu("王五",3);

    private final String name;
    private final int age;

    private MyTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    @Override
    public String toString() { return "MyTest{" + "name='" + name + '\'' + ", age=" + age + '}'; }
}

