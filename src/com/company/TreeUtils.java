package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class TreeUtils {

    static class LevelNode {
        TreeNode node;
        int level;
    }

    static void printLevels(final TreeNode root) {
        List<String> levels = new LinkedList<String>();

        LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
        queue.add(new LevelNode(){{node=root; level=0;}});

        while (!queue.isEmpty()) {
            LevelNode levelNode = queue.removeFirst();

            // add node value to current level
            final int currentLevel = levelNode.level;
            if (levels.size() == currentLevel)
                levels.add("");

            String levelString = levels.get(currentLevel);
            levelString += levelNode.node.value + ",";
            levels.set(currentLevel, levelString);

            // add leaf nodes to queue if exist
            final TreeNode leftNode = levelNode.node.left;
            final TreeNode rightNode = levelNode.node.right;

            if (leftNode != null)
                queue.add(new LevelNode(){{node = leftNode; level = currentLevel + 1;}});
            if (rightNode != null)
                queue.add(new LevelNode(){{node = rightNode; level = currentLevel + 1;}});
        }

        for (String level : levels)
            System.out.println(level);

    }


    static Iterator<Integer> getIterator(TreeNode root){
        LinkedList<Integer> list = new LinkedList<Integer>();

        return list.iterator();
    }


}
