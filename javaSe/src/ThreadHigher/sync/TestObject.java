package ThreadHigher.sync;

import java.lang.ref.WeakReference;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestObject {
    public static void main(String[] args) {
        ThreadLocal<Integer> i=new ThreadLocal<>();
        i.set(1);
        i.set(2);
        Integer integer = i.get();
        System.out.println(integer);//输出2
    }
}
