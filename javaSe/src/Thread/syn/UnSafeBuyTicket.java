package Thread.syn;

public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTickets b=new BuyTickets();
        new Thread(b,"我").start();
        new Thread(b,"你").start();
        new Thread(b,"它").start();
    }
}

class BuyTickets implements Runnable{
    private int ticketNuMS=10;
    boolean flag=true;
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void buy() throws InterruptedException {
        if (ticketNuMS<=0){
            flag=false;
            return;
        }
        Thread.sleep(100);
        System.out.println(Thread.currentThread().getName()+"买到"+ticketNuMS--);
    }
}