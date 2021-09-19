package os;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: LiYuan
 * @version: 1.0
 * @create: 2020-03-13
 **/
@Slf4j
public class DiskInfo {

    private static DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");

    /**
     * 获取磁盘使用信息
     *
     * @return
     */
    public static List<Map<String, String>> getInfo() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        File[] roots = File.listRoots();// 获取磁盘分区列表
        for (File file : roots) {
            Map<String, String> map = new HashMap<String, String>();

            long freeSpace=file.getFreeSpace();
            long totalSpace=file.getTotalSpace();
            long usableSpace=totalSpace-freeSpace;

            map.put("path", file.getPath());
            map.put("freeSpace", freeSpace / 1024 / 1024 / 1024 + "G");// 空闲空间
            map.put("usableSpace", usableSpace / 1024 / 1024 / 1024 + "G");// 可用空间
            map.put("totalSpace",totalSpace / 1024 / 1024 / 1024 + "G");// 总空间
            map.put("percent", DECIMALFORMAT.format(((double)usableSpace/(double)totalSpace)*100)+"%");// 总空间

            list.add(map);
        }

        return list;
    }

    public static float memoryUsage() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        long physicalFree = osmxb.getFreePhysicalMemorySize();
        long physicalTotal = osmxb.getTotalPhysicalMemorySize();
        long physicalUse = physicalTotal - physicalFree;

        float usage = ((float)physicalUse) / physicalTotal;
        log.info("physicalTotal:{},physicalFree:{},physicalUse:{}, usage:{}",
                physicalTotal, physicalFree, physicalUse, usage);
        return usage;
    }

    public static float diskUsage() {
        File[] roots = File.listRoots();
        long allTotalSpace = 0;
        long allFreeSpace = 0;
        long allUsableSpace = 0;
        for (File file : roots) {
            long freeSpace = file.getFreeSpace();
            long totalSpace = file.getTotalSpace();
            allTotalSpace = allTotalSpace + totalSpace;
            allFreeSpace = allFreeSpace + freeSpace;
        }
        allUsableSpace = allTotalSpace - allFreeSpace;
        float usage = ((float)allUsableSpace) / allTotalSpace;
        log.info("allTotalSpace:{},allFreeSpace:{},allUsableSpace:{}, usage:{}",
                allTotalSpace, allFreeSpace, allUsableSpace, usage);
        return usage;
    }

    public static void main(String[] args) {

        System.out.println(getInfo());
        memoryUsage();
        diskUsage();
    }

}
