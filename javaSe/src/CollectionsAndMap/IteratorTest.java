package CollectionsAndMap;

import org.junit.Test;

import java.util.*;

public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();

        coll.add("AA");
        coll.add("BB");
        coll.add(123);//自动装箱
        coll.add(new Date());

        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            if ("AA".equals(next)){
                iterator.remove();
            }
        }
        System.out.println(coll);//[BB, 123, Sat Jan 23 16:04:46 CST 2021]

    }
}
