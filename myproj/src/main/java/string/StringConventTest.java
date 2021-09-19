package string;

import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-03-06
 **/
@Slf4j
public class StringConventTest {
    public static void main(String[] args) throws Exception {
        StringConventTest stringConventTest = new StringConventTest();

        stringConventTest.test1();

        stringConventTest.test2();
    }

    public void test1() {
        Float f = Float.parseFloat("0.62");
        log.info("f:{}", f);
    }

    public void test2() throws Exception {
        InetAddress address = null;
        try {
//            address = InetAddress.getByName("www.yiibai.com");
//            address = InetAddress.getByName("node5");
            address = InetAddress.getByName("10.8.6.121");

            InetAddress addr = InetAddress.getByAddress( new byte[]{(byte)10,(byte)8,(byte)6,(byte)121} );
            System.out.println( addr.getCanonicalHostName() );
            System.out.println( addr.getHostName() );

        } catch (UnknownHostException e) {
            log.error("UnknownHostException:", e);
        }
        System.out.println(address.getHostName() + " IP is = " + address.getHostAddress());
    }

}
