package os;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-03-13
 **/
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

public class MonitorInfoTest {

    public static void main(String[] args) {

        // ��������ڴ������ѯ
        long vmFree = 0;
        long vmUse = 0;
        long vmTotal = 0;
        long vmMax = 0;
        int byteToMb = 1024 * 1024;
        Runtime rt = Runtime.getRuntime();
        vmTotal = rt.totalMemory() / byteToMb;
        vmFree = rt.freeMemory() / byteToMb;
        vmMax = rt.maxMemory() / byteToMb;
        vmUse = vmTotal - vmFree;
        System.out.println("JVM�ڴ����õĿռ�Ϊ��" + vmUse + " MB");
        System.out.println("JVM�ڴ�Ŀ��пռ�Ϊ��" + vmFree + " MB");
        System.out.println("JVM���ڴ�ռ�Ϊ��" + vmTotal + " MB");
        System.out.println("JVM���ڴ�ռ�Ϊ��" + vmMax + " MB");

        System.out.println("======================================");
        // ����ϵͳ���ڴ������ѯ
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        String os = System.getProperty("os.name");
        long physicalFree = osmxb.getFreePhysicalMemorySize() / byteToMb;
        long physicalTotal = osmxb.getTotalPhysicalMemorySize() / byteToMb;
        long physicalUse = physicalTotal - physicalFree;
        System.out.println("����ϵͳ�İ汾��" + os);
        System.out.println("����ϵͳ�����ڴ����õĿռ�Ϊ��" + physicalFree + " MB");
        System.out.println("����ϵͳ�����ڴ�Ŀ��пռ�Ϊ��" + physicalUse + " MB");
        System.out.println("����ϵͳ�������ڴ棺" + physicalTotal + " MB");

        // ����߳�����
        ThreadGroup parentThread;
        int totalThread = 0;
        for (parentThread = Thread.currentThread().getThreadGroup(); parentThread
                .getParent() != null; parentThread = parentThread.getParent()) {
            totalThread = parentThread.activeCount();
        }
        System.out.println("����߳�����:" + totalThread);
    }
}