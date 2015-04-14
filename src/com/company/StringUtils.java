package com.company;

/**
 * Created by nate on 4/6/15.
 */
public class StringUtils {

    static String addBinaryNum(String b1, String b2){
        b1 = reverse(b1);
        b2 = reverse(b2);

        int length = b1.length();
        char[] chars1 = b1.toCharArray();
        char[] chars2 = b2.toCharArray();

        //carry
        int carry = 0;

        String out = "";

        for (int i=0; i < length; i++ ) {
            int num1 = Integer.parseInt(chars1[i] + "");
            int num2 = Integer.parseInt(chars2[i] + "");

            int sum = num1 + num2 + carry;

            if (sum == 1) {
                carry = 0;
            } else if (sum == 2) {
                sum = 0;
                carry = 1;
            } else if (sum == 3) {
                sum = 1;
                carry = 1;
            } else {
                carry = 0;
            }

            out += sum + "";

        }

        out += carry;

        return reverse(out);
    }


    private static String reverse(String s){
        char[] chars = s.toCharArray();

        for (int i=0, j=chars.length-1; i<j; i++,j--){
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
        }

        String out = "";
        for (char c : chars)
            out += c;

        return out;
    }


}
