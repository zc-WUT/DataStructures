package lambda;

public class Lambda {


    //静态内部类
      static class Like2 implements ILike {
        @Override
        public void lambda() {
            System.out.println("lmbda2");
        }
    }

    public static void main(String[] args) {
        ILike iLike=new Like();
        iLike.lambda();

        iLike=new Like2();
        iLike.lambda();
        class Like3 implements ILike {

            @Override
            public void lambda() {
                System.out.println("lmbda3");
            }
        }
        iLike=new Like3();
        iLike.lambda();

        iLike=() ->{
            System.out.println("lamda5");
        };
        iLike.lambda();
    }
}

interface ILike {
    void lambda();
}

class Like implements ILike {

    @Override
    public void lambda() {
        System.out.println("lmbda");
    }
}