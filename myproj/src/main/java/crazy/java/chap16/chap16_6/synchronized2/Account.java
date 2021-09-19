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
	//��ʶ�˻����Ƿ����д������
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
			//���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ����ȡǮ��������
			if (!flag)
			{
                while(!flag) {
                    wait();
                }
			}
			else
			{
				//ִ��ȡǮ
				System.out.println(Thread.currentThread().getName() + 
					" ȡǮ:" +  drawAmount);
				balance -= drawAmount;
				System.out.println("�˻����Ϊ��" + balance);
				//����ʶ�˻��Ƿ����д��������Ϊfalse��
				flag = false;
				//���������߳�
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
			//���flagΪ�棬�����˻��������˴�Ǯ��ȥ�����Ǯ��������
			if (flag)
			{
                while(flag) {
                    wait();
                }
			}
			else
			{
				//ִ�д��
				System.out.println(Thread.currentThread().getName() + 
					" ���:" +  depositAmount);
				balance += depositAmount;
				System.out.println("�˻����Ϊ��" + balance);
				//����ʾ�˻��Ƿ����д��������Ϊtrue
				flag = true;
				//���������߳�
               
                System.out.println("Thread id:" +  Thread.currentThread().getName() + "notifyAll");
                
				notifyAll();
			}
            
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "leave" + "�˻����Ϊ��" + balance);
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
			//���flagΪ�٣������˻��л�û���˴�Ǯ��ȥ����ȡǮ��������

            while(!flag) {
                wait();
            }
			
            //ִ��ȡǮ
            System.out.println(Thread.currentThread().getName() + 
                " ȡǮ:" +  drawAmount);
            balance -= drawAmount;
            System.out.println("�˻����Ϊ��" + balance);
            //����ʶ�˻��Ƿ����д��������Ϊfalse��
            flag = false;
            //���������߳�
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
			//���flagΪ�棬�����˻��������˴�Ǯ��ȥ�����Ǯ��������

            while(flag) {
                wait();
            }


            //ִ�д��
            System.out.println(Thread.currentThread().getName() + 
                " ���:" +  depositAmount);
            balance += depositAmount;
            System.out.println("�˻����Ϊ��" + balance);
            //����ʾ�˻��Ƿ����д��������Ϊtrue
            flag = true;
            //���������߳�
           
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "notifyAll");
            
            notifyAll();
			
            
            System.out.println("Thread id:" +  Thread.currentThread().getName() + "leave" + "�˻����Ϊ��" + balance);
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