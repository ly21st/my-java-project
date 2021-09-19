package crazy.java.chap15.chap15_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-04
 **/
public class FileOutputStreamTest {
    public static void main(String[] args) throws  Exception {
        String path = System.getProperty("user.dir");
        String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_3/FileOutputStreamTest.java";
        System.out.println("file:" + file);

        String outFile = path + File.separator + "src/main/java/crazy/java/chap15/chap15_3/newFile.txt";

        FileInputStream fin = null;
        FileOutputStream fout = null;

        try {
            fin = new FileInputStream(file);
            fout = new FileOutputStream(outFile);
            int hasRead;
            byte []buf = new byte[32];

            while (true) {
                hasRead = fin.read(buf);
                if (hasRead > 0) {
                    fout.write(buf, 0 , hasRead);
                } else {
                    break;
                }
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (fin != null) {
                fin.close();
            }

            if (fout != null) {
                fout.close();
            }

        }

    }
}
