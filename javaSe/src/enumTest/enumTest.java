package enumTest;

public enum enumTest {
    ZhangSan("zhangchi",1), LiSi("ζε",2),WangWu("ηδΊ",3);

    private final String name;
    private final int age;

    private enumTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }

    public int getAge() { return age; }

    @Override
    public String toString() { return "MyTest{" + "name='" + name + '\'' + ", age=" + age + '}'; }
}
