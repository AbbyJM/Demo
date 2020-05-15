package com.abby.container;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class MapDemo {
    private static Map<Integer,Integer> hashMap = new HashMap<>();
    private static TreeMap<Integer,Integer> treeMap = new TreeMap<>();

    //用于等待所有的线程执行完毕
    private static CountDownLatch latch = new CountDownLatch(100);

    public  static void main(String[] args){
//         hashMapBasicOperation();
//       multiThreadDemo();
        treeMapBasicOperation();
    }

    /**
     * TreeMap的基本操作
     */
    private static void treeMapBasicOperation(){
        System.out.println("使用默认的比较器比较key：");
        treeMap.put(2,2);
        treeMap.put(1,1);
        treeMap.put(10,10);
        treeMap.put(9,9);
        printMap(treeMap);
    }

    /**
     * HashMap的基本操作
     */
    private static void hashMapBasicOperation(){
        hashMap.put(1,1);
        hashMap.put(2,2);
        System.out.println("插入元素1和2之后");
        printMap(hashMap);

        hashMap.remove(1);
        System.out.println("删除元素1之后");
        printMap(hashMap);

        System.out.println("插入key已经存在的value,将覆盖旧的值");
        hashMap.put(2,3);
        printMap(hashMap);

        System.out.println("如果key存在，则直接返回不更新");
        Integer old = hashMap.putIfAbsent(2,4);
        System.out.println(String.format("旧的值为: %d",old));
    }

    /**
     * HashMap多线程演示
     */
    private static void multiThreadDemo() {
        //开启一百条线程
        for (int i=0;i<100;i++) {
            new Thread(() -> {
                for (int j=0;j<100000;j++){
                    hashMap.put(j,j);
                }
                latch.countDown();
            }).start();
        }

        //查看HashMap是否有丢失
        for (int i=0;i<100000;i++){
            if (hashMap.get(i)==null) {
                System.out.println("loss value");
            }
        }
    }

    /**
     * 打印HashMap中所有的KV对
     */
    private static void printMap(Map<Integer,Integer> m){
        for(Map.Entry<Integer,Integer> entry:m.entrySet()){
            System.out.print(m.getClass().getName());
            System.out.println(String.format(" key is %d,value is %d",entry.getKey(),entry.getValue()));
        }
        System.out.println();
    }
}
