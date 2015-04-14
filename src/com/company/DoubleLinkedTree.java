package com.company;

/**
 * Created by nate on 4/7/15.
 */
public class DoubleLinkedTree {

    final TreeNode root;
    final TreeNode head;

    DoubleLinkedTree(TreeNode root, TreeNode head) {
        this.root = root;
        this.head = head;
    }

    static DoubleLinkedTree factory(TreeNode root) {
        TreeNode head = root;

        while(head.left != null)
            head = head.left;

        DoubleLinkedTree dlt = new DoubleLinkedTree(root, head);
        TreeNode tail = link(null, root);

        tail.next = head;
        head.previous = tail;

        return dlt;
    }

    private static TreeNode link(TreeNode tail, TreeNode node){
        if (node == null)
            return tail;

        //in-order dfs
        TreeNode leftTail = link(tail, node.left);
        addToTail(leftTail, node);
        return link(node, node.right);
    }

    private static TreeNode addToTail(TreeNode tail, TreeNode node){
        if (tail == null) {
            tail = node;
        }

        tail.next = node;
        node.previous = tail;

        return node;

    }
}
