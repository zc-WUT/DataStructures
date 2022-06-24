import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.*;

public class MakeTest {
    public static void main(String[] args) {
        long l = Runtime.getRuntime().maxMemory();
        long l1 = Runtime.getRuntime().totalMemory();
        System.out.println(l/(double)1024/1024);
        System.out.println(l1/(double)1024/1024);
        while (true){

        }
    }
}

class  A{
    byte[] arr=new byte[1*1024*1024];
    public static void main(String[] args) {
        int count=0;
        List<A> list=new ArrayList<>();
        try {
            while (true){
                list.add(new A());
                count++;
            }
        } catch (Error e) {
            System.out.println("count   "+count);
        }
    }
}

class B{
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < 17; i++) {
            sb.append("1");
        }
        System.out.println(sb.capacity());
    }
}
