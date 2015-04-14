package com.company;

import java.util.HashSet;

/**
 * Created by nate on 4/6/15.
 */
public class LinkedListUtils {

    static LinkNode arrayToLinkedList(final int[] ary){
        if (ary == null || ary.length == 0)
            return null;

        LinkNode head = new LinkNode(){{value=ary[0];}};
        LinkNode temp = head;

        for (int i = 1; i < ary.length; i++, temp = temp.next) {
            temp.next = new LinkNode();
            temp.next.value = ary[i];
        }

        return head;
    }

    static void printLinks(LinkNode head){

        String out = "";

        while (head != null) {
            out += head.value + ",";
            head = head.next;
        }

        System.out.println("List: " + out);

    }

    static LinkNode reverseLinks(LinkNode head){

        LinkNode reversedHead = null;

        while (head != null){
            LinkNode temp = head.next;
            head.next = reversedHead;
            reversedHead = head;
            head = temp;
        }

        return reversedHead;
    }

    static boolean hasLoop(LinkNode head){

        if (head == null)
            return false;

        LinkNode slow, fast;

        slow = fast = head;

        while (true) {

            slow = slow.next;

            if (fast.next == null)
                return false;
            else
                fast = fast.next.next;

            if (slow == null || fast == null)
                return false;

            if (slow == fast)
                return true;

        }

    }

    static LinkNode insert(LinkNode head, int pos, int value){

        LinkNode node = new LinkNode();
        node.value = value;

        if (pos == 0) {
            node.next = head;
            return node;
        }

        LinkNode prev = head;
        LinkNode curr = head.next;

        int i = 1;
        while (i < pos) {
            i++;
            prev = curr;
            curr = curr.next;
        }

        node.next = curr;
        prev.next = node;

        return head;

    }

    static LinkNode remove(LinkNode head, int pos){
        if (head == null)
            return null;

        if (pos < 0)
            return head;

        if (pos == 0)
            return head.next;

        LinkNode prev = head;
        LinkNode curr = head.next;

        int i = 1;
        while (i < pos && curr != null) {
            i++;
            prev = curr;
            curr = curr.next;
        }

        if (curr != null) {
            prev.next = curr.next;
        }

        return head;
    }

    static LinkNode removeDuplicates(LinkNode head) {

        if (head == null || head.next == null)
            return head;

        HashSet<Integer> set = new HashSet<>();
        set.add(head.value);

        LinkNode previous = head;
        LinkNode current = head.next;

        while (current != null) {

            if (set.contains(current.value)) {
                // current is duplicate, remove it, update only current pointer
                previous.next = current.next;
                current = current.next;
            } else {
                // current is NOT duplicate, add value to set, update both pointers
                set.add(current.value);
                previous = previous.next;
                current = current.next;
            }

        }

        return head;
    }

    static LinkNode moveNode(LinkNode head, int from, int to){

        if (head == null || head.next == null || from == to)
            return head;

        if (from < to)
            to -= 1;

        LinkNode temp = getNode(head, from);
        head = removeNode(head, from);
        head = addNode(head, temp, to);

        return head;
    }

    static LinkNode getNode(LinkNode head, int pos){
        if (pos < 0)
            return null;

        LinkNode temp = head;
        int i = 0;

        while(i != pos) {
            i++;
            temp = temp.next;
        }

        return temp;
    }

    static LinkNode removeNode(LinkNode head, int pos) {

        if (pos == 0) {
            return head.next;
        }

        LinkNode previous = getNode(head, pos - 1);
        LinkNode current = previous.next;
        previous.next = current.next;

        return head;
    }

    static LinkNode addNode(LinkNode head, LinkNode node, int pos){
        if (pos == 0) {
            node.next = head;
            return node;
        }

        LinkNode previous = getNode(head, pos - 1);
        LinkNode current = previous.next;

        node.next = current;
        previous.next = node;

        return head;

    }

    // swap

    static LinkNode swapNodes(LinkNode head, int pos1, int pos2){
        if (head == null || head.next == null || pos1 == pos2)
            return head;

        // get node refs
        LinkNode node1 = getNode(head, pos1);
        LinkNode node2 = getNode(head, pos2);

        LinkNode temp1 = new LinkNode(){{value=-1;}};
        LinkNode temp2 = new LinkNode(){{value=-2;}};

        // replace node 1 with place-holder-node-1
        head = replace(head, node1, temp1);
        // replace node 2 with place-holder-node-2
        head = replace(head, node2, temp2);

        // replace place-holder-node-1 with node 2
        head = replace(head, temp1, node2);
        // replace place-holder-node-2 with node 1
        head = replace(head, temp2, node1);

        return head;
    }

    static LinkNode replace(LinkNode head, LinkNode oldNode, LinkNode newNode) {

        if (head == oldNode) {
            newNode.next = head.next;
            return newNode;
        }

        LinkNode tempPrevious = head;
        LinkNode temp = head.next;

        while (temp != oldNode) {
            tempPrevious = tempPrevious.next;
            temp = temp.next;
        }

        tempPrevious.next = newNode;
        newNode.next = temp.next;

        return head;
    }


    static LinkNode[] split(LinkNode head, int cnt){

        if (head == null)
            return null;

        LinkNode[] lists = new LinkNode[cnt];
        LinkNode tempHead = head;

        // add the rest
        int toggle = 0;
        while (tempHead != null) {
            LinkNode temp = tempHead;
            LinkNode listHead = lists[toggle];

            tempHead = tempHead.next;
            temp.next = listHead;

            // add temp to list and toggle
            lists[toggle] = temp;

            toggle = ++toggle % cnt;
        }

        return lists;

    }

}
