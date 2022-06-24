package Thread.Lock;

public class DeadLock {
    public static void main(String[] args) {
        MakeUp g1=new MakeUp(0,"灰姑凉");
        MakeUp g2=new MakeUp(1,"公主");
        g1.start();
        g2.start();
    }
}

class Lipsticl {//口红

}

class Mirror {

}

class MakeUp extends Thread {
    static Lipsticl lipsticl = new Lipsticl();//需要的资源只有一份
    static Mirror mirror = new Mirror();//需要的资源只有一份
    int choice;
    String name;

    MakeUp(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {//互相持有对方的锁
        if (choice == 0) {
            synchronized (lipsticl) {//获得口红的锁
                System.out.println(this.name+"获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){//一秒钟之后向获得镜子
                    System.out.println(this.name+"获得镜子的锁");
                }
            }
        }else {
            synchronized (mirror) {//获得口红的锁
                System.out.println(this.name+"获得镜子的锁");
                Thread.sleep(1000);
                synchronized (lipsticl){//一秒钟之后向获得镜子
                    System.out.println(this.name+"获得口红的锁");
                }
            }
        }
    }
}
