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
public class Account
{
	private String accountNo;
	private double balance;
	//标识账户中是否已有存款的旗标
	private boolean flag = false;

	public Account(){}

	public Account(String accountNo , double balance)
	{
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void setAccountNo(String accountNo)
	{
		this.accountNo = accountNo;
	}
	public String getAccountNo()
	{
		 return this.accountNo;
	}

	public double getBalance()
	{
		 return this.balance;
	}
    
    /*
	public synchronized void draw(double drawAmount)
	{
		try
		{
			//如果flag为假，表明账户中还没有人存钱进去，则取钱方法阻塞
			if (!flag)
			{
                while(!flag) {
                    wait();
                }
			}
			else
			{
				//执行取钱
				System.out.println(Thread.currentThread().getName() + 
					" 取钱:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额为：" + balance);
				//将标识账户是否已有存款的旗标设为false。
				flag = false;
				//唤醒其他线程
				notifyAll();
			}
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount)
	{
		try
		{
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "enter" );
            System.out.print("flag=");
            System.out.println(flag);
			//如果flag为真，表明账户中已有人存钱进去，则存钱方法阻塞
			if (flag)
			{
                while(flag) {
                    wait();
                }
			}
			else
			{
				//执行存款
				System.out.println(Thread.currentThread().getName() + 
					" 存款:" +  depositAmount);
				balance += depositAmount;
				System.out.println("账户余额为：" + balance);
				//将表示账户是否已有存款的旗标设为true
				flag = true;
				//唤醒其他线程
               
                System.out.println("Thread id:" +  Thread.currentThread().getName() + "notifyAll");
                
				notifyAll();
			}
            
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "leave" + "账户余额为：" + balance);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
    */
    
    public synchronized void draw(double drawAmount)
	{
		try
		{
			//如果flag为假，表明账户中还没有人存钱进去，则取钱方法阻塞

            while(!flag) {
                wait();
            }
			
            //执行取钱
            System.out.println(Thread.currentThread().getName() + 
                " 取钱:" +  drawAmount);
            balance -= drawAmount;
            System.out.println("账户余额为：" + balance);
            //将标识账户是否已有存款的旗标设为false。
            flag = false;
            //唤醒其他线程
            notifyAll();
			
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
	public synchronized void deposit(double depositAmount)
	{
		try
		{
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "enter" );
            System.out.print("flag=");
            System.out.println(flag);
			//如果flag为真，表明账户中已有人存钱进去，则存钱方法阻塞

            while(flag) {
                wait();
            }


            //执行存款
            System.out.println(Thread.currentThread().getName() + 
                " 存款:" +  depositAmount);
            balance += depositAmount;
            System.out.println("账户余额为：" + balance);
            //将表示账户是否已有存款的旗标设为true
            flag = true;
            //唤醒其他线程
           
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "notifyAll");
            
            notifyAll();
			
            
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "leave" + "账户余额为：" + balance);
		}
		catch (InterruptedException ex)
		{
			ex.printStackTrace();
		}
	}
    

	public int hashCode()
	{
		return accountNo.hashCode();
	}
	public boolean equals(Object obj)
	{
		if (obj != null && obj.getClass() == Account.class)
		{
			Account target = (Account)obj;
			return target.getAccountNo().equals(accountNo);
		}
		return false;
	}
}