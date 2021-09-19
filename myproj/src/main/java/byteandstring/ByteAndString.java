package byteandstring;

import org.apache.commons.lang.StringUtils;

/**
 * @description: byte and string
 * @author: LiYuan liyuan@agree.com.cn
 * @version: 1.0
 * @ create: 2019-02-09 21:27
 **/
public class ByteAndString {
    public static void main(String[] args) {
        strToByte();
        byteToStr();
        toByteArray("123456");
        byte[] b={(byte)0xB8,(byte)0xDF,(byte)0xCB,(byte)0xD9};
        toHexString(b);
    }

    public static void strToByte() {
        String str = "罗长";
        byte []sb = str.getBytes();
        System.out.println("sb:" + sb);
    }

    public static void byteToStr() {
        byte[] b={(byte)0xB8,(byte)0xDF,(byte)0xCB,(byte)0xD9};
        String str= new String (b);
        System.out.println("str:" + str);
    }

    /**
     * 16进制的字符串表示转成字节数组
     *
     * @param hexString
     *            16进制格式的字符串
     * @return 转换后的字节数组
     **/
    public static byte[] toByteArray(String hexString) {
        if (StringUtils.isEmpty(hexString))
            throw new IllegalArgumentException("this hexString must not be empty");

        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        //因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
        for (int i = 0; i < byteArray.length; i++) {
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }

    /**
     * 字节数组转成16进制表示格式的字符串
     *
     * @param byteArray
     *            需要转换的字节数组
     * @return 16进制表示格式的字符串
     **/
    public static String toHexString(byte[] byteArray) {
        if (byteArray == null || byteArray.length < 1)
            throw new IllegalArgumentException("this byteArray must not be null or empty");

        final StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteArray.length; i++) {
            //0~F前面不零
            if ((byteArray[i] & 0xff) < 0x10) {
                hexString.append("0");
            }
            hexString.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return hexString.toString().toLowerCase();
    }

}
