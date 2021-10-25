package crazy.java.chap15.chap15_9;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class RandomFileChannelTest
{
	public static void main(String[] args)
	{
		FileChannel randomChannel = null;
		try
		{
			String path = System.getProperty("user.dir");
			String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_9/a.txt";
			System.out.println("file:" + file);


			File f = new File(file);
			//����һ��RandomAccessFile����
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			//��ȡRandomAccessFile��Ӧ��Channel
			randomChannel = raf.getChannel();
			//��Channel����������ӳ���ByteBuffer
			ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY,
				0 , f.length());
			//��Channel�ļ�¼ָ���ƶ������
			randomChannel.position(f.length());
			//��buffer�������������
			randomChannel.write(buffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (randomChannel != null)
					randomChannel.close();
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
