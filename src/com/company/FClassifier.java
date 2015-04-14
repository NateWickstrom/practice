package com.company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nate on 4/13/15.
 */
public class FClassifier {


    public static boolean isFactor(int number, int potentialFactor){
        return number % potentialFactor == 0;
    }

    public static Set<Integer> factors(int number){
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++ ) {
            if (isFactor(number, i)) {
                factors.add(number);
                factors.add(number / i);
            }
        }
        return factors;
    }

    public static boolean isPrime(int number){
        Set<Integer> factors = new HashSet<>();
        factors.add(number);
        factors.add(1);
        return factors.equals(factors(number));
    }

}
