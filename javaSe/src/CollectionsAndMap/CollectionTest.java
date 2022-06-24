package CollectionsAndMap;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test01() {
        Set set=new HashSet();
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("BB");
        set.add("BB");
        System.out.println(set);//[AA, BB, 456, 123]
    }
    @Test
    public void test02() {
        Set set=new LinkedHashSet();
        set.add("CC");
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("BB");
        set.add("BB");
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void test03() {
        Set set=new TreeSet();
        set.add(1223);
        set.add(456);
        System.out.println(set);//[456, 1223]

    }
}
