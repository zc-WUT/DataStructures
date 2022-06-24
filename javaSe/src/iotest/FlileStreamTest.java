package iotest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FlileStreamTest {
    @Test
    public void test01() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("3.jpg");
            File file1 = new File("4.jpg");
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1,true);
            int len;
            byte[] buffer = new byte[100];
            long l = System.currentTimeMillis();
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            long l2 = System.currentTimeMillis();
            System.out.println(l2-l);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos == null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
