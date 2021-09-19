package crazy.java.chap9.chap9_3;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-05-29
 **/
public class TestStringBuilder
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        //追加字符串
        sb.append("java");//sb = "java"
        //插入
        sb.insert(0 , "hello "); //sb="hello java"
        //替换
        sb.replace(5, 6, ","); //sb="hello java"
        //删除
        sb.delete(5, 6);//sb="hellojava"
        System.out.println(sb);
        //反转
        sb.reverse();//sb="avajolleh"
        System.out.println(sb);
        System.out.println(sb.length()); //输出9
        System.out.println(sb.capacity());  //输出16
        //改变StringBuilder的长度，将只保留前面部分
        sb.setLength(5); //sb="avajo"
        System.out.println(sb);
    }
}
