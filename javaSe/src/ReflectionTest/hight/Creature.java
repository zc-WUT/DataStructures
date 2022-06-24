package ReflectionTest.hight;

import java.io.Serializable;

public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("呼吸");
    }

    public void eat(){
        System.out.println("吃东西");
    }
}
