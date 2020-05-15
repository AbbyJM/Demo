package com.abby.container;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    private static HashSet<Integer> hashSet = new HashSet<>();
    private static TreeSet<Integer> treeSet = new TreeSet<>();

    public static void main(String[] args) {
//       hashSetBasicOperation();
        treeSetBasicOperation();
    }

    private static void treeSetBasicOperation(){
        System.out.println("TreeSet保证唯一性和排序");
        for(int i=10;i>0;i--){
            treeSet.add(i);
        }
        for(int i=10;i>0;i--){
            treeSet.add(i);
        }
        printSet(treeSet);
    }

    /**
     * HashSet的基本操作
     */
    private static void hashSetBasicOperation(){
        for(int i=0;i<10;i++){
            hashSet.add(i);
        }
        for(int i=0;i<10;i++){
            hashSet.add(i);
        }
        printSet(hashSet);
    }

    /**
     * 打印Set中的内容
     * @param set 待打印的Set
     */
    private static void printSet(Set<Integer> set){
        System.out.println(set.getClass().getName()+":");
        for (Integer i:set){
            System.out.println(i);
        }
    }
}
