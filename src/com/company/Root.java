package com.company;

/**
 * Created by nate on 4/13/15.
 */
public class Root {

    public static double square(double number){

        if (number < 0)
            throw new ArithmeticException();

        double left = 0;
        double right = Math.max(1, number);

        while (right - left > 10e-3) {
            double mid = left + (right - left) / 2;
            if (mid*mid > number)
                right = mid;
            else
                left = mid;
        }

        return left;
    }

    public static double cube(double number){
        number = Math.abs(number);

        double left = 0;
        double right = Math.max(1, number);
        while (right - left > 10e-3) {
            double mid = left + (right - left) / 2;
            if (mid*mid*mid > number)
                right = mid;
            else
                left = mid;
        }

        return left;
    }

}
