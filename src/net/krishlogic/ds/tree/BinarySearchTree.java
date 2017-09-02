package net.krishlogic.ds.tree;

import net.krishlogic.ds.Node;

public class BinarySearchTree {

    static Node root;


    public Node buildSortedTree(int arr[], int start, int end) {

        if(start > end) {
            return null;
        }

        int mid = (start + end)/2;

        Node node = new Node(arr[mid]);

        node.left = buildSortedTree(arr, start, mid - 1);
        node.right = buildSortedTree(arr, mid+1, end);

        return node;
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.id);
        preOrder(node.left);
        preOrder(node.right);
    }

    public boolean isBST(Node node, int start, int end) {

        if (node == null) {
            return true;
        }

        if (node.id < start || node.id > end) {
            return false;
        }

        return (isBST(node.left, start, node.id -1) && isBST(node.right, node.id +1 , end));
    }

    public static void main(String args[]){

        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        System.out.println("is BST: " + tree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        root = tree.buildSortedTree(arr, 0, arr.length-1);
        tree.preOrder(root);
    }
}
