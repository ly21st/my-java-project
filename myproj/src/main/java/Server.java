import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description: tcp server
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-07 18:35
 **/
public class Server {
    private int port = 1122;
    private ServerSocket serverSocket;

    public Server() throws Exception {
        serverSocket = new ServerSocket(port, 3);
        System.out.println("服务器启动成功!");
    }

    public static void main(String [] argv) throws Exception {
        Server server = new Server();
        Thread.sleep(60000 );
        System.out.println("begin server.service");
        server.service();
    }

    public void service() {
        while(true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("new connection accepted" + socket.getInetAddress() + ":"
                        + socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
