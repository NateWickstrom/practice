package com.company;

/**
 * Created by nate on 4/6/15.
 */
public class BinarySearch {

    final int[] array;

    BinarySearch(int[] array){
        this.array = array;
    }

    int find (int target){

        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + ( right - left ) / 2;

            if (target == array[mid])
                return mid;
            else if (target > array[mid])
                left = mid + 1;
            else
                right = mid - 1;

        }

        // return the closest
        if (right < 0)
            return left;
        if (left == array.length)
            return right;
        if (Math.abs(array[left] - target) > Math.abs(array[right] - target))
            return right;

        return left;
    }

}
