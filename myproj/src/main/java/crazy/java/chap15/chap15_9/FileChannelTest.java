package crazy.java.chap15.chap15_9;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

/**
 * Description:
 * <br/>Copyright (C), 2005-2008, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
public class FileChannelTest
{
	public static void main(String[] args)
	{
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try
		{
			String path = System.getProperty("user.dir");
			String file = path + File.separator + "src/main/java/crazy/java/chap15/chap15_9/FileChannelTest.java";
			System.out.println("file:" + file);

			String outfile = path + File.separator + "src/main/java/crazy/java/chap15/chap15_9/a.txt";

			File f = new File(file);
			//����FileInputStream���Ը��ļ�����������FileChannel
			inChannel = new FileInputStream(f)
				.getChannel();
			//��FileChannel���ȫ������ӳ���ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY,
				0 , f.length());
			//ʹ��GBK���ַ���������������
			Charset charset = Charset.forName("GBK");
			//���ļ����������FileBuffer�����Կ������
			outChannel = new FileOutputStream(outfile)
				.getChannel();
			//ֱ�ӽ�buffer�������ȫ�����
			outChannel.write(buffer);
			//�ٴε���buffer��clear()��������ԭlimit��position��λ��
			buffer.clear();
			//����������(CharsetDecoder)����
			CharsetDecoder decoder = charset.newDecoder();
			//ʹ�ý�������ByteBufferת����CharBuffer
			CharBuffer charBuffer =  decoder.decode(buffer);
			//CharBuffer��toString�������Ի�ȡ��Ӧ���ַ���
			System.out.println(charBuffer);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			try
			{
				if (inChannel != null)
					inChannel.close();
				if (outChannel != null)
					outChannel.close();	
			}
			catch (IOException ex)
			{
				ex.printStackTrace();
			}
		}
	}
}
