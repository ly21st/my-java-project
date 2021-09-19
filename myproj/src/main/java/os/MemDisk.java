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
        //1. 获取本机盘符
        File[] roots = File.listRoots();
        for (int i = 0; i < roots.length; i++) {
            System.out.print(roots[i].getPath()+"; ");//磁盘路径
            System.out.print(roots[i].getTotalSpace()/1024/1024/1024+"; ");//磁盘总空间大小
            System.out.print(roots[i].getUsableSpace()/1024/1024/1024+"; ");//剩余磁盘空间大小
            System.out.println(roots[i].getFreeSpace()/1024/1024/1024);//剩余磁盘空间大小
        }
    }


    public static void getDiskInfo()
    {
        File[] disks = File.listRoots();
        for(File file : disks)
        {
            System.out.print(file.getPath() + "    ");
            System.out.print("空闲未使用 = " + file.getFreeSpace() / 1024 / 1024 + "M" + "    ");// 空闲空间
            System.out.print("已经使用 = " + file.getUsableSpace() / 1024 / 1024 + "M" + "    ");// 可用空间
            System.out.print("总容量 = " + file.getTotalSpace() / 1024 / 1024 + "M" + "    ");// 总空间
            System.out.println();
        }
    }

    public static void getMemInfo()
    {
        OperatingSystemMXBean mem = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        System.out.println("Total RAM：" + mem.getTotalPhysicalMemorySize() / 1024 / 1024 + "MB");
        System.out.println("Available　RAM：" + mem.getFreePhysicalMemorySize() / 1024 / 1024 + "MB");
    }

}
