package Thread.demo02;

//静态代理
public class StaticProxy {
    public static void main(String[] args) {
        //代理对象  代理 真实对象
        You you = new You();
        you.happyMarry();
        new WeddingCompany(you).happyMarry();
    }
}

//真实对象：你
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("我要结婚了，好hi呦");
    }
}


//代理对象：婚庆公司
class WeddingCompany implements Marry{

    //婚庆需要有你这个人 ， 代理对象需要代理一个真实对象
    private Marry you;

    public WeddingCompany(Marry you){
        this.you = you;
    }

    @Override
    public void happyMarry() {
        before();
        this.you.happyMarry();//你要结婚
        after();
    }

    private void before() {
        System.out.println("结婚之前，布置洞房");
    }
    private void after() {
        System.out.println("结婚之后，催你收钱");
    }

}


//共同的接口：结婚
interface Marry{
    void happyMarry();
}
