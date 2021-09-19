package crazy.java.chap15.chap15_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-06-19
 **/
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");
        String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_3/FileInputStreamTest.java";
        System.out.println("file:" + file);
        FileInputStream fis = new FileInputStream(file);
        byte[] bbuf = new byte[1024];
        int hasRead = 0;
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.print(new String(bbuf,0,hasRead));
        }
        fis.close();
    }
}















