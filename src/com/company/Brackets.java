package com.company;

import java.util.Stack;

/**
 * Created by nate on 4/6/15.
 */
public class Brackets {

    static boolean isBalanced(String s) {
        return isBalanced(s, "(", ")");
    }

    static boolean isBalanced(String s, String open, String close){
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String current = s.charAt(i) + "";
            String prev = stack.isEmpty() ? "" : stack.peek();

            if(current.equals(open)) {
                stack.push(current);
            }

            if (current.equals(close)) {
                if (prev.equals(open))
                    stack.pop();
                else
                    return false;
            }

        }

        return stack.isEmpty();

    }

}
