package com.abby.container;

import java.util.*;

public class ListDemo {
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static LinkedList<Integer> linkedList = new LinkedList<>();
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
//       benchmarking();
         linkedListBasicOperation();
    }

    private static void linkedListBasicOperation(){
        System.out.println("向linkedList插入元素1:");
        linkedList.add(1);
        printList(linkedList);
        System.out.println("向linkedList头部插入元素2：");
        linkedList.addFirst(2);
        printList(linkedList);
    }

    /**
     * 对List的性能做比较
     */
    private static void benchmarking(){
        insertAndPrintTime(arrayList,100000);
        insertAndPrintTime(linkedList,100000);
        insertAndPrintTime(vector,100000);
        System.out.println();

        //从0开始读取每个容器内的元素，统计访问性能
        readAndPrintTime(arrayList);
        readAndPrintTime(linkedList);
        readAndPrintTime(vector);
        System.out.println();

        //删除各个容器内的元素，统计删除性能
        deleteAndPrintTime(arrayList);
        deleteAndPrintTime(linkedList);
        deleteAndPrintTime(vector);
    }

    /**
     * 向List插入元素并打印时间
     * @param list 插入的List
     * @param count 插入元素的个数
     */
    private static void insertAndPrintTime(List<Integer> list,int count){
        System.out.print(list.getClass().getName());
        long start = System.currentTimeMillis();
        for (int i=0;i<count;i++){
            list.add(0,i);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format(" 插入%d个元素,耗时%d毫秒",count,cost));
    }

    /**
     * 删除List中的所有元素并打印时间
     * @param list 待测试的List
     */
    private static void deleteAndPrintTime(List<Integer> list) {
        System.out.print(list.getClass().getName());
        long start = System.currentTimeMillis();
        int size = list.size();
        for (int i=0;i<size;i++){
            list.remove(0);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format(" 删除%d个元素,耗时%d毫秒",size,cost));
    }

    /**
     * 从头开始读取容器中的每一个元素并打印时间
     * @param list 待测试的List
     */
    private static void readAndPrintTime(List<Integer> list){
        System.out.print(list.getClass().getName());
        long start = System.currentTimeMillis();
        int size = list.size();
        for (int i=0;i<size;i++){
            Integer result = list.get(i);
        }
        long cost = System.currentTimeMillis() - start;
        System.out.println(String.format(" 读取%d个元素，耗时%d毫秒",size,cost));
    }

    private static void printList(List<Integer> l){
        System.out.println(l.getClass().getName()+":");
        for (Integer integer : l) {
            System.out.println(integer);
        }
    }
}
