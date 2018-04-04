package com.cyp.algorithm.BinaryTree;

import java.util.Stack;

/**
 * @Author pierre
 * 18-3-16
 * 二叉树
 */
public class BinTree {
    private BinTree pre;
    private int value;
    private BinTree next;
    private int size;

    public static BinTree createBinTree(int[] origin) {
        if (origin.length > 0) {
            BinTree binTree = new BinTree();
            binTree.size = origin.length;
            int middle = origin.length / 2;
            binTree.value = origin[middle];
            if (middle > 0) {
                binTree.pre = createBinTree(getSub(origin, 0, middle - 1));
                binTree.next = createBinTree(getSub(origin, middle + 1, origin.length - 1));
            }
            return binTree;
        }
        return null;
    }

    public static void traversal(BinTree binTree) {
        if (binTree != null) {
            traversal(binTree.next);
            System.out.print(binTree.value + "\t");
            traversal(binTree.pre);
        }
    }

    public static void middleTraversal(BinTree binTree) {
        if (binTree != null) {
            middleTraversal(binTree.pre);
            System.out.print(binTree.value + "\t");
            middleTraversal(binTree.next);
        }
    }

    /**
     * 非递归遍历
     */
    public static void notRecuriseTraversal(BinTree binTree) {
        Stack<BinTree> stack = new Stack<>();
        while (binTree != null || !stack.isEmpty()) {
            while (binTree != null) {
                stack.push(binTree);
                //System.out.print(binTree.value + "\t");//中序循环
                binTree = binTree.next;
            }
            if (!stack.isEmpty()) {
                BinTree bt = stack.pop();
                System.out.print(bt.value + "\t");//中序循环
                binTree = bt.pre;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        BinTree binTree = createBinTree(a);
        traversal(binTree);
        System.out.println();
        middleTraversal(binTree);
        System.out.println();
        notRecuriseTraversal(binTree);
        System.out.println();
    }

    private static int[] getSub(int[] origin, int start, int end) {
        int[] result = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            result[i - start] = origin[i];
        }
        return result;
    }
}
