package ThreadHigher.AQS;

import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MLock implements Lock {
    private MySyn mySyn = new MySyn();
    ReentrantLock lock = new ReentrantLock();

    @Test
    public void test() {
        lock.lock();
        lock.unlock();
    }

    @Override
    public void lock() {
        mySyn.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        mySyn.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    private class MySyn extends AbstractQueuedSynchronizer {


        @Override
        protected boolean tryAcquire(int arg) {
            assert arg == 1;
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());// Exclusive 独有的，排它的
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if (!isHeldExclusively()) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }
    }
}
