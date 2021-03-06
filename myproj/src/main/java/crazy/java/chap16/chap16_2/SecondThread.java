package crazy.java.chap16.chap16_2;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
//通过实现Runnable接口来创建线程类
public class SecondThread implements Runnable
{
	private int i ;
	//run方法同样是线程执行体
	public void run()
	{
		for ( ; i < 100 ; i++ )
		{
			//当线程类实现Runnable接口时，
			//如果想获取当前线程，只能用Thread.currentThread()方法。
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
	}
	
    public static void main(String[] args) 
    {
        for (int i = 0; i < 100;  i++)
        {
			System.out.println(Thread.currentThread().getName() + "  " + i);
			if (i == 20)
			{
				SecondThread st = new SecondThread();
				//通过new Thread(target , name)方法创建新线程
				new Thread(st , "新线程1").start();
				new Thread(st , "新线程2").start();
			}
        }
    }
}