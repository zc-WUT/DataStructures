package Thread.demo1;
//线程创建方式一 ：
/*
第一步：继承Thread类
第二步：重写run（）方法
第三步：创建继承了Thread类的对象 ， 调用start（）方法启动。
 */
public class TestThread01 extends Thread{
    @Override
    public void run() {
        //线程执行体
        for (int i = 0; i < 20; i++) {
            System.out.println("有人在写笔记-->"+i);
        }
    }

    //主线程
    public static void main(String[] args) {
        //创建线程对象
        TestThread01 testThread01=new TestThread01();
        //start（） 方法用来 启动线程；
        testThread01.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("有人在在睡觉sleep-->"+i);
        }
    }
}
