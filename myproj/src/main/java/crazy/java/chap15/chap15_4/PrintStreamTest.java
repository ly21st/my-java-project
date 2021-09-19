package crazy.java.chap15.chap15_4;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-04
 **/
public class PrintStreamTest {
    public static void main(String[] args) throws Exception {
        String path = System.getProperty("user.dir");
        String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_4/aa.txt";
        System.out.println("file:" + file);
        PrintStream ps = null;

        try {
            FileOutputStream fout = new FileOutputStream(file);
            ps = new PrintStream(fout);
            ps.println("普通字符串");
            ps.println(new PrintStreamTest());
        } catch (Exception ex) {

        } finally {
            ps.close();
        }
    }
}
