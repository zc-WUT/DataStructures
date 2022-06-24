package ThreadHigher.sync;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
    public static void main(String[] args) {
        WeakReference<CAS> m=new WeakReference<>(new CAS());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<CAS> t1 =new ThreadLocal<>();

        ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
        ThreadLocal<String> stringLocal = new ThreadLocal<String>();

        t1.set(new CAS());
        t1.remove();
    }
}
