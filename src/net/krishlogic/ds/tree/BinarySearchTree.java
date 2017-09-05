package net.krishlogic.ds.tree;

import net.krishlogic.ds.Node;
import net.krishlogic.ds.tree.BinaryTree;

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

    public Node search(Node node, int key) {

        if (node == null) {
            return node;
        }

        if (node.id == key) {
            return node;
        }

        if (node.id > key) {
            return search(node.left, key);
        }

        if (node.id < key) {
            return search(node.right, key);
        }

        return null;
    }

    public Node insertRecord(Node root, int id, String value) {
        if (root == null) {
            root = new Node(id, value);

            return root;
        }

        if (root.id < id) {
            insertRecord(root.left, id, value);
        }

        if (root.id > id) {
            insertRecord(root.right, id, value);
        }

        return root;
    }

    public void insert(int id, String value) {
        this.root = insertRecord(root, id, value);
    }

    public static void main(String args[]) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.root = new Node(4, "four");
        tree.root.left = new Node(2, "two");
        tree.root.right = new Node(5, "five");
        tree.root.left.left = new Node(1, "one");
        tree.root.left.right = new Node(3, "three");

        System.out.println("is BST: " + tree.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
        Node n = tree.search(root, 5);
        System.out.println("\n" + n.id + " " + n.value);

        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        root = tree.buildSortedTree(arr, 0, arr.length - 1);
        tree.preOrder(root);


        BinarySearchTree tree1 = new BinarySearchTree();

        tree1.insert(6, "six");
        tree1.insert(9, "nine");
        tree1.insert(5, "five");
        tree1.insert(2, "two");
        tree1.insert(8, "eight");
        tree1.insert(1, "one");

        System.out.println("ORDERS:");

        tree1.preOrder(root);
        BinaryTree bt = new BinaryTree();
        System.out.println("Sorted tree:");
        bt.inOrderTraversal(root);
    }
}
