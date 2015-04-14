package com.company;

/**
 * Created by nate on 4/6/15.
 */
public class Fibonacci {

    static int getValueAtIndex(int index){
        if (index == 0)
            return 1;

        if (index == 1)
            return 1;

        int prev = 1;
        int prevPrev = 1;


        for (int i = 2; i <= index; i++) {
            int temp = prevPrev;
            prevPrev = prev;
            prev = prev + temp;
        }

        return prev;
    }
}
