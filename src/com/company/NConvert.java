package com.company;

/**
 * Created by nate on 4/13/15.
 */
public class NConvert {


    public static String toBase2(int number){

        int temp = number;
        String out = "";

        while (temp >= 2) {
            int remainder = temp % 2;
            temp /= 2;
            out = remainder + out;
        }

        return temp + out;
    }

    public static int fromBase2(String binaryNum){

        char[] chars = binaryNum.toCharArray();
        int out = 0;

        for(int i = 0, j = chars.length-1; i < chars.length; i++, j--) {
            if (chars[j] == '1')
                out += Math.pow(2,i);

        }

        return out;

    }

}
