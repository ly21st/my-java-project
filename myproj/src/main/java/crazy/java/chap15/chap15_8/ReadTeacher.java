package crazy.java.chap15.chap15_8;

import java.io.*;
/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class ReadTeacher
{
	public static void main(String[] args) 
	{
		ObjectInputStream ois = null;
		try
		{
			String path = System.getProperty("user.dir");
			String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_8/teacher.txt";
			System.out.println("file:" + file);

			//����һ��ObjectInputStream������
			ois = new ObjectInputStream(
				new FileInputStream(file));
			//���ζ�ȡObjectInputStream�������е��ĸ�����
			Teacher t1 = (Teacher)ois.readObject();
			Teacher t2 = (Teacher)ois.readObject();
			Person p = (Person)ois.readObject();
			Teacher t3 = (Teacher)ois.readObject();
			//���true
			System.out.println("t1��student���ú�p�Ƿ���ͬ��"
				+ (t1.getStudent() == p));
			//���true
			System.out.println("t2��student���ú�p�Ƿ���ͬ��"
				+ (t2.getStudent() == p));
			//���true
			System.out.println("t2��t3�Ƿ���ͬһ������"
				+ (t2 == t3));
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (ois != null)
					ois.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
