package crazy.java.chap15.chap15_3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-06-19
 **/
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        try {
            String path = System.getProperty("user.dir");
            String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_3/FileReaderTest.java";
            System.out.println("file:" + file);
            fr = new FileReader(file);
            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                System.out.print(new String(cbuf, 0, hasRead));
            }
        } finally {
            if (fr != null) {
                fr.close();
            }
        }
    }
}
