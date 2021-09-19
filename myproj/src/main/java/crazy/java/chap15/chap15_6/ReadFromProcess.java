package crazy.java.chap15.chap15_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-07-05
 **/
public class ReadFromProcess {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = null;
        InputStreamReader isr = null;
        char[] buf = new char[32];
        int hasRead = 0;
        String str;

        try {
            Process p = Runtime.getRuntime().exec("javac");
            br = new BufferedReader(new InputStreamReader(p.getErrorStream()));

            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } {
            if (br != null) {
                br.close();
            }
        }
    }
}
