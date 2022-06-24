package Thread.state;

public class TestDeamon {
    public static void main(String[] args) {
        God g=new God();
        You you=new You();

        Thread thread=new Thread(g);
        thread.setDaemon(true);
        thread.start();
        new Thread(you).start();
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝守护你");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("开心的活着");
        }
        System.out.println("goodBye");
    }
}
