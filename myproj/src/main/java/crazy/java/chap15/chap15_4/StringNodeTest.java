package crazy.java.chap15.chap15_4;

import java.io.StringReader;
import java.io.StringWriter;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-04
 **/
public class StringNodeTest {
    public static void main(String[] args) throws  Exception {
        String str = "Whether 60 or 16,there is in every human being¡¯s heart\n"
                + " the lure of wonders,the unfailing appetite for \n"
                + "what's next and the joy of the game of living.\n"
                + "In the center of your heart and my heart,there is a wireless station; \n"
                + "so long as it receives messages of beauty,hope,courage and power from \n";

        StringReader sr = null;
        int hasRead = 0;
        char[] buf = new char[32];
        try {
            sr =  new StringReader(str);
            while ( (hasRead = sr.read(buf)) > 0) {
                System.out.print(new String(buf, 0 , hasRead));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sr != null) {
                sr.close();
            }
        }

        StringWriter sw = new StringWriter(20);
        sw.write("good,this is vear good\n");
        sw.write("good,this is vear good\n");
        sw.write("good,this is vear good\n");
        sw.write("good,this is vear good\n");
        sw.write("good,this is vear good\n");
        System.out.println("--------------------------");
        System.out.println(sw.toString());
    }
}
