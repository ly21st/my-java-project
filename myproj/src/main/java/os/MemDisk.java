package os;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-03-13
 **/
import com.sun.management.OperatingSystemMXBean;

import java.io.File;
import java.lang.management.ManagementFactory;

public class MemDisk
{
    public static void main(String[] args)
    {
        getMemInfo();
        System.out.println();
        getDiskInfo();
        System.out.println("");
        getDisk2();
    }

    public static void getDisk2() {
        //1. ��ȡ�����̷�
        File[] roots = File.listRoots();
        for (int i = 0; i < roots.length; i++) {
            System.out.print(roots[i].getPath()+"; ");//����·��
            System.out.print(roots[i].getTotalSpace()/1024/1024/1024+"; ");//�����ܿռ��С
            System.out.print(roots[i].getUsableSpace()/1024/1024/1024+"; ");//ʣ����̿ռ��С
            System.out.println(roots[i].getFreeSpace()/1024/1024/1024);//ʣ����̿ռ��С
        }
    }


    public static void getDiskInfo()
    {
        File[] disks = File.listRoots();
        for(File file : disks)
        {
            System.out.print(file.getPath() + "    ");
            System.out.print("����δʹ�� = " + file.getFreeSpace() / 1024 / 1024 + "M" + "    ");// ���пռ�
            System.out.print("�Ѿ�ʹ�� = " + file.getUsableSpace() / 1024 / 1024 + "M" + "    ");// ���ÿռ�
            System.out.print("������ = " + file.getTotalSpace() / 1024 / 1024 + "M" + "    ");// �ܿռ�
            System.out.println();
        }
    }

    public static void getMemInfo()
    {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Total RAM��" + mem.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
        System.out.println("Available��RAM��" + mem.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
    }

}
