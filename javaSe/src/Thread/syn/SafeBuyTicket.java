package Thread.syn;

public class SafeBuyTicket {
    public static void main(String[] args) {
        SafeBuyTickets b = new SafeBuyTickets();
        new Thread(b, "我").start();
        new Thread(b, "你").start();
        new Thread(b, "它").start();
    }
}

class SafeBuyTickets implements Runnable {
    private int ticketNuMS = 1000;
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNuMS <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(10);
        System.out.println(Thread.currentThread().getName() + "买到" + ticketNuMS--);
    }
}