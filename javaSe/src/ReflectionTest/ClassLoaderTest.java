package ReflectionTest;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@dad5dc
        //调用系统类加载器的getParent（）：获取扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);//sun.misc.Launcher$ExtClassLoader@5ede7b
        //调用扩展类加载器的getParent()：无法获取引导类加载器
        //引导类加载器主要负责加载java的核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);//null
    }

    @Test
    public void test2() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();

        //读取配置文件的方式：配置文件路径识别为当前module的src下
        InputStream inputStream = classLoader.getResourceAsStream("ReflectionTest\\jdbc.properties");
        properties.load(inputStream);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user+"   "+password);
    }
}
