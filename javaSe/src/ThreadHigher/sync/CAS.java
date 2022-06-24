package ThreadHigher.sync;

import org.junit.Test;
import org.openjdk.jol.info.ClassLayout;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class CAS {
    public static void main(String[] args) {
        AtomicInteger i=new AtomicInteger(1);
        i.incrementAndGet();
        Object o = new Object();

        ReentrantLock lock=new ReentrantLock(true);

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        ReferenceQueue<TestObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference reference = new PhantomReference<>(new TestObject(), referenceQueue);

        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        reference.clear();
    }

}
