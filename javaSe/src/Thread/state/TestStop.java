package Thread.state;

public class TestStop implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println(i);
            i++;
        }
    }

    public void stop(){
        this.flag=false;
    }

    public static void main(String[] args) {
        TestStop testStop=new TestStop();
        new Thread(testStop).start();
        for (int i = 0; i < 100000; i++) {
            if (i==90000){
                testStop.stop();
                System.out.println("结束了");
            }
        }
    }
}
