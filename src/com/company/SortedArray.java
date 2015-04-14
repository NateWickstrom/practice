package com.company;

/**
 * Created by nate on 4/6/15.
 */
public class SortedArray {

    final int[] array;

    SortedArray(int[] array) {
        this.array = array;
    }

    TreeNode toBst(final int lower, final int upper) {

        if (upper < lower)
            return null;

        if (upper == lower)
            return new TreeNode(){{ value = array[lower];}};

        final int mid = lower + (upper - lower) / 2;
        TreeNode node = new TreeNode(){{ value = array[mid];}};

        node.left = toBst(lower, mid - 1);
        node.right = toBst(mid + 1, upper);

        return node;
    }

    TreeNode toBst(){
        return toBst(0, array.length - 1);
    }

}
