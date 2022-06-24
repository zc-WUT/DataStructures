package Thread.state;


public class TestSleep implements Runnable{
    //票
    private int ticketNums = 10;

    @Override
    public void run() {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void test() throws InterruptedException {
        //执行体
        while (true){
            if (ticketNums<=0){
                break;
            }
            //模拟网络延时，睡眠
            Thread.sleep(200);

            //获取线程名字
            System.out.println(Thread.currentThread().getName()+"-->抢到了第"+ticketNums--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep t = new TestSleep();

        //第二个参数，创建线程名字
        new Thread(t,"小明").start();
        new Thread(t,"老师").start();
        new Thread(t,"黄牛党").start();
    }

}
