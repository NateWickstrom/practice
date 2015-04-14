package com.company;

import java.util.HashSet;

/**
 * Created by nate on 4/6/15.
 */
public class MyMath {

    static int getSqrt(int num){
        if (num < 1)
            return Integer.MAX_VALUE;

        if (num == 1)
            return 1;

        int guess = 1;
        while (guess*guess < num){
            ++guess;
        }

        if (guess*guess == num)
            return guess;

        return --guess;

    }

    static void sum3(int[] a){

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i : a)
            set.add(i);

        for (int i=0; i< a.length; i++) {
            for (int j=0; j< a.length; j++) {
                if (j == i)
                    continue;

                int sum = - a[i] - a[j];
                if (set.contains(sum)) {
                    System.out.println("SUM: " + a[i] + "," + a[j] + "," + sum);
                    return;
                }
            }
        }
        System.out.println("Sum not found");

    }

    static void sum2(int[] a){
        HashSet<Integer> set = new HashSet<Integer>();

        for (int i : a)
            set.add(i);

        for (int i=0; i< a.length; i++) {
            if (set.contains(-a[i])) {
                System.out.println("SUM: " + a[i] + "," + ( -a[i]));
                return;
            }
        }

        System.out.println("Sum not found");
    }

    void printArray(int[] a){
        String out = "";
        for (int i : a)
            out += i + ",";
        System.out.println(out);

    }

}
