package ReflectionTest.hight;

@MyAnn
public class Person extends Creature<String> implements Comparable<String>,MyInterface{
    private String name;
    int age;
    public int id;

    public Person() {
    }
    @MyAnn(value = "hi")
    private Person(String name) {
        this.name = name;
    }

     Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnn
    private String show(String nation){
        System.out.println("我是个"+nation);
        return nation;
    }

    public String dis(String interest){
        return interest;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {

    }

    public static void showDesc(){
        System.out.println("静态方法");
    }
}
