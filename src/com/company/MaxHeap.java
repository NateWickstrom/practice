package com.company;

/**
 * Created by nate on 4/13/15.
 */
public class MaxHeap {

    class MaxHeapNode extends TreeNode {
        boolean goLeft = true;

        MaxHeapNode (int value) { this.value = value;}
    }

    MaxHeapNode head;

    void push(int value) {
        head = push(head, new MaxHeapNode(value));
    }

    int pop(){
        int ret = head.value;

        if (head.left == null && head.right != null) {
            head = (MaxHeapNode) head.right;
        } else if (head.left != null && head.right == null) {
            head = (MaxHeapNode) head.left;
        } else if (head.left != null && head.right != null) {
            head = push((MaxHeapNode) head.left, (MaxHeapNode) head.right);
        } else {
            head = null;
        }

        return ret;
    }

    private MaxHeapNode push(MaxHeapNode root, MaxHeapNode node) {
        if (root == null) return node;

        //compare
        if (root.value < node.value) {
            int temp = root.value;
            root.value = node.value;
            node.value = temp;
        }

        if (root.goLeft)
            root.left = push((MaxHeapNode) root.left, node);
        else
            root.right = push((MaxHeapNode) root.right, node);

        root.goLeft = !root.goLeft;

        return root;
    }

    void print(){
        if (head != null)
            TreeUtils.printLevels(head);
    }

}
