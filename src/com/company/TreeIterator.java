package com.company;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by nate on 4/6/15.
 */
public class TreeIterator {

    TreeNode root;

    TreeIterator(TreeNode root){
        this.root = root;
    }

    Iterator<Integer> get() {
        return dfs(new LinkedList<Integer>(), root).iterator();
    }

    LinkedList<Integer> dfs(LinkedList<Integer> list, TreeNode node) {
        if (node == null)
            return list;

        dfs(list, node.left);
        list.addLast(node.value);
        dfs(list, node.right);

        return list;
    }
}
