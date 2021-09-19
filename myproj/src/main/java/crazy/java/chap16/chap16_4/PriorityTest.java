package crazy.java.chap16.chap16_4;

/**
 * Description:
 * <br/>Copyright (C), 2008-2010, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class PriorityTest extends Thread
{
	public PriorityTest(){}
	//����һ���в����Ĺ����������ڴ����߳�ʱָ��name
	public PriorityTest(String name)
	{
		super(name);
	}
	public void run()
	{
		for (int i = 0 ; i < 50 ; i++ )
		{
			System.out.println(getName() +  ",�����ȼ��ǣ�"
				+ getPriority() + ",ѭ��������ֵΪ:" + i);
		}
	}
	public static void main(String[] args) 
	{
		//�ı����̵߳����ȼ�
		Thread.currentThread().setPriority(6);
		for (int i = 0 ; i < 30 ; i++ )
		{
			if (i == 10)
			{
				PriorityTest low  = new PriorityTest("�ͼ�");
				low.start();
				System.out.println("����֮�������ȼ�:" + low.getPriority());
				//���ø��߳�Ϊ������ȼ�
				low.setPriority(Thread.MIN_PRIORITY);
			}
			if (i == 20)
			{
				PriorityTest high = new PriorityTest("�߼�");
				high.start();
				System.out.println("����֮�������ȼ�:" + high.getPriority());
				//���ø��߳�Ϊ������ȼ�
				high.setPriority(Thread.MAX_PRIORITY);
			}
		}
	}
}