package CollectionsAndMap;

import org.junit.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test01(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put(45,1234);
        map.put("BB",56);

        //遍历所有的Key集：keySet（）
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();

        //遍历所有的value集：values（）
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }

        //遍历所有的key-value：entrySet（）
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object next = iterator1.next();
            Map.Entry entry= (Map.Entry) next;
            System.out.println(entry.getKey()+"     "+entry.getValue());
        }
    }

    @Test
    public  void  test02(){
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(1,1);
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
    }
}
