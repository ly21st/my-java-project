package crazy.java.chap18.chap18_1;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */

class Tester
{
	static
	{
		System.out.println("Tester类的静态初始化块...");
	}
}
public class ClassLoaderTest
{
	public static void main(String[] args) 
		throws ClassNotFoundException
	{
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		//下面语句仅仅是加载Tester类
//		cl.loadClass("Tester");
		cl.loadClass("crazy.java.chap18.chap18_1.Tester");
		System.out.println("系统加载Tester类");
		//下面语句才会初始化Tester类
//		Class.forName("Tester");
		Class.forName("crazy.java.chap18.chap18_1.Tester");

		String a="";
		System.out.println("a:" + a.isEmpty());


	}
}
