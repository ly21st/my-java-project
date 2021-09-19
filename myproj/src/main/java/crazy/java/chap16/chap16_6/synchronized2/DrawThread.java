package crazy.java.chap16.chap16_6.synchronized2;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */

public class DrawThread extends Thread
{
	//模拟用户账户
	private Account account;
	//当前取钱线程所希望取的钱数
	private double drawAmount;

	public DrawThread(String name , Account account , 
		double drawAmount)
	{
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}

	//重复100次执行取钱操作
	public void run()
	{
        try {
         //   for (int i = 0 ; i < 100 ; i++ )
            for (int i = 0 ; i < 1 ; i++ )
            {
                Thread.sleep(1000);
                account.draw(drawAmount);
        //        Thread.sleep(1000);
            }
        }
        catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
}