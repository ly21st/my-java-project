package crazy.java.chap16.chap16_4;

/**
 * @author  yeeku.H.lee kongyeeku@163.com
 * @version  1.0
 * <br>Copyright (C), 2005-2008, yeeku.H.Lee
 * <br>This program is protected by copyright laws.
 * <br>Program Name:
 * <br>Date: 
 */
 
 /*
public class JoinThread extends Thread
{
	//提供一个有参数的构造器，用于设置该线程的名字
	public JoinThread(String name)
	{
		super(name);
	}
	//重写run方法，定义线程执行体
	public void run()
	{
		for (int i = 0; i < 100 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
    public static void main(String[] args) throws Exception
    {
		//启动子线程
		new JoinThread("新线程").start();
		for (int i = 0; i < 100 ; i++ )
		{
			if (i == 20)
			{
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				//main线程调用了jt线程的join方法，main线程
				//必须等jt执行结束才会向下执行
				jt.join(); 
			}
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
    }
}

*/




public class JoinThread extends Thread
{
	//提供一个有参数的构造器，用于设置该线程的名字
	public JoinThread(String name)
	{
		super(name);
	}
	//重写run方法，定义线程执行体
	public void run()
	{
		for (int i = 0; i < 10 ; i++ )
		{
			System.out.println(getName() + "  " + i);
		}
	}
    public static void main(String[] args) throws Exception
    {
		//启动子线程
		new JoinThread("新线程").start();
		for (int i = 0; i < 100 ; i++ )
		{
			if (i == 20)
			{
				JoinThread jt = new JoinThread("被Join的线程");
				jt.start();
				//main线程调用了jt线程的join方法，main线程
				//必须等jt执行结束才会向下执行
				jt.join(); 
			}
			System.out.println(Thread.currentThread().getName() + "  " + i);
		}
        
        System.out.println("isDaemon: "+ Thread.currentThread().isDaemon());
    }
}






















