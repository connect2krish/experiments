package net.krishlogic.ds.tree;

import net.krishlogic.ds.Node;

public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * traversal inorder: Left - root - right
     * @param node
     */
    public void inOrderTraversal(Node node) {

        if (node == null) {
            return;
        }

        inOrderTraversal(node.left);

        System.out.println("id: " + node.id);

        inOrderTraversal(node.right);
    }

    /**
     * traversal post order: Left - Right - root
     * @param node
     */
    public void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println("id: " + node.id);
    }

    /**
     * traversal pre-order : root - left - right
     * @param node
     */
    public void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.println("id: " + node.id);

        preOrderTraversal(node.left);

        preOrderTraversal(node.right);
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        } else {

            int left = getHeight(node.left);
            int right = getHeight(node.right);

            if (left > right) {
                return left + 1;
            } else {
                return right + 1;
            }

        }
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);

        System.out.println("pre order traversal=");
        binaryTree.preOrderTraversal(binaryTree.root);

        System.out.println("post order traversal=");
        binaryTree.postOrderTraversal(binaryTree.root);

        System.out.println("in order traversal=");
        binaryTree.inOrderTraversal(binaryTree.root);

        int height = binaryTree.getHeight(binaryTree.root);
        System.out.println("height: " + height);
    }
}