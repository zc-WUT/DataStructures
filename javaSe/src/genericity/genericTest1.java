package genericity;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;

public class genericTest1 {
    @Test
    public void test01(){
        Order<java.io.Serializable> order=new Order<java.io.Serializable>();
        order.setOrderT(123);
        order.setOrderT("A");

        Order<String> order1=new Order<>("AA",1001,"A");
    }

    @Test
    public void test02(){
        SubOrder order=new SubOrder();
        order.setOrderT(1122);
    }

    @Test
    public void test03(){
        List<? super Integer> list = null;
        list = new ArrayList<Number>();
        list.add(1);
//        Number number = list.get(0);//报错，因为List<? super Integer>不知道list存放的对象具体类型,则使用get获取到的值不确定。
        list.add(1);//正确
    }

    @Test
    public void test04(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        Integer integer = list.get(0);
        System.out.println(integer);// 1
    }
    public static void main(String[] args) {
        HashMap<String,String> map=new HashMap();
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry);
        }

    }
}
