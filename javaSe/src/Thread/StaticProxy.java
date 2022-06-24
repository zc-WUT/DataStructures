package Thread;

public class StaticProxy {
    public static void main(String[] args) {
        WeddingCompany weddingCompany=new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry {
    void HappyMarry();
}

//真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("结婚了，开心");
    }
}

//代理角色
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("步骤现场");
    }

    private void before() {
        System.out.println("收尾款");
    }
}