import java.net.Socket;

/**
 * @description: tcp client
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-07 18:50
 **/
public class Client {
    public static void main(String[] argv) throws Exception {
        final int length = 100;
        String host = "localhost";
        int port = 1122;
        Socket[] socket= new Socket[length];
        for(int i = 0; i < length; i++) {
            socket[i] = new Socket(host, port);
            System.out.println("第" + i + "次连接成功!");
        }
        Thread.sleep(3000);
        for (int i = 0; i < length; i++) {
            socket[i].close();
        }
    }
}
