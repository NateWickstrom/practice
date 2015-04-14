package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        int[] a = new int[]{0,1,2,3,4,5,6,8,9};
//
//        SortedArray s = new SortedArray(a);
//
//        TreeNode node = s.toBst();
//
//        DoubleLinkedTree dlt = DoubleLinkedTree.factory(node);
//
//        TreeNode temp = dlt.head;
//
//        String out = "";
//        out += temp.value;
//        temp = temp.next;
//
//
//        while (temp != null && temp != dlt.head) {
//            out += temp.value;
//            temp = temp.next;
//        }


        print(new BinarySearch(a).find(7));


    }

    static void print(int[] a) {
        String out = "";
        for (int i : a)
            out += i + ",";
        print(out);
    }

    static void print(int i) {
        print(i + "");
    }

    static void print(String string){
        System.out.println(string);
    }
}
