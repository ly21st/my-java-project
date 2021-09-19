package lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: lambda test
 * @author: LiYuan
 * @version: 1.0
 * @create: 2019-04-26
 **/
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest lambda = new LambdaTest();
//        lambda.test1();
//        lambda.test2();
//        lambda.test3();
//        lambda.uuid();
//        lambda.lowercase();
//        lambda.variable();
//        lambda.whatThis();
//        lambda.stream();
//        lambda.streamMap();
//        lambda.streamExam();
//        lambda.collectTest();
//        lambda.reduceTest();
        lambda.streamMatch();
    }

    public void test1() {
        Thread td = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello thread.");
            }
        });
        td.start();
    }

    public void test2() {
        Thread td = new Thread(() -> System.out.println("hello lambda"));
        td.start();
    }

    public void test3() {
        List<String> list = Arrays.asList(new String[]{"hello", "world", "good"});
        Collections.sort(list, (str1, str2) -> str1.compareTo(str2));
        System.out.println("list:" + list);
    }

    public void uuid() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("uuid:" + uuid);
    }

    public void lowercase() {
        List<String> proNames = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
     //   List<String> lowercaseNames1 = proNames.stream().map(name->{return name.toLowerCase();}).collect(Collectors.toList());
        List<String> lowercaseNames1 = proNames.stream().map(String::toLowerCase).collect(Collectors.toList());

        System.out.println("lowercaseNames1:" + lowercaseNames1);
    }

    public void variable() {
        String waibu = "lambda:";
        List<String> proStrs = Arrays.asList(new String[]{"Ni", "Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(chuandi -> {
            Long zidingyi = System.currentTimeMillis();
            return waibu + chuandi + "------:" + zidingyi;
        }).collect(Collectors.toList());
//        System.out.println("execStrs:" + execStrs);
        execStrs.forEach(System.out::println);
    }

    public void whatThis() {
        List<String> proStrs = Arrays.asList(new String[]{"Ni","Hao","Lambda"});
        List<String> execStrs = proStrs.stream().map(str->{
            System.out.println(this.getClass().getName());
            return str.toLowerCase();
        }).collect(Collectors.toList());
        execStrs.forEach(System.out::println);
    }

    public void stream() {
//        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
//        List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
        List<Integer> nums = Arrays.asList(1,null,3,4,null,6);
        long count = nums.stream().filter(num -> num != null).count();
        System.out.println("count:" + count);
    }

    public void streamMap() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2,3),
                Arrays.asList(4,5,6)
        );
        Stream<Integer> outputStream = inputStream.flatMap(childList->childList.stream());
//        Stream<List<Integer>> outputStream = inputStream.map(childList->{return childList;});

        List<Integer> list = outputStream.collect(Collectors.toList());

        System.out.println(list);
    }

    public void streamExam() {
        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        System.out.println("sum is:" + nums.stream().filter(num->num != null).
                distinct()
                .mapToInt(num -> num * 2)
                .peek(System.out::println)
                .skip(2)
                .limit(4)
                .sum());
    }

    public void collectTest() {
        List<Integer> nums = Arrays.asList(1,1,null,2,3,4,null,5,6,7,8,9,10);
        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null)
                .collect(()->new ArrayList<Integer>(),
                        (list,item)->list.add(item),
                        (list1,list2)->list1.addAll(list2));
//        List<Integer> numsWithoutNull = nums.stream().filter(num -> num != null).
//                collect(Collectors.toList());
        System.out.println(numsWithoutNull);
    }

    public void reduceTest() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//        System.out.println(list.stream().reduce((sum,item)->sum + item).get());
        System.out.println(list.stream().reduce(0,(sum,item)->sum + item));
    }

    public void streamMatch() {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().allMatch(item-> item < 100));

        list.stream().max((item1,item2)->item1.compareTo(item2)).ifPresent(System.out::println);
    }


}



