package Thread.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//多线程实现图片下载
public class TestThread02 extends Thread{
    private String url;
    private String name;//保存的文件名

    public TestThread02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader=new WebDownloader();
        try {
            webDownloader.downloader(url,name);
            System.out.println("下载了图片-->"+name);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO出错");
        }
    }

    public static void main(String[] args) {
        TestThread02 t1=new TestThread02("https://p0.ssl.qhimgs1.com/bdr/300_115_/t01ce6b3f6e807f6c9c.jpg","1.jpg");
        TestThread02 t2=new TestThread02("https://p0.ssl.qhimgs1.com/bdr/300_115_/t01ce6b3f6e807f6c9c.jpg","2.jpg");
        TestThread02 t3=new TestThread02("https://p0.ssl.qhimgs1.com/bdr/300_115_/t01ce6b3f6e807f6c9c.jpg","3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }
}

//下载图片
class WebDownloader{
    public void downloader(String url,String name) throws IOException {
        FileUtils.copyURLToFile(new URL(url),new File(name));
    }
}
