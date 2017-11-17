package net.krishlogic.ds.tree;

import net.krishlogic.ds.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Vector;

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
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (leftHeight > rightHeight) {
            return leftHeight + 1;
        } else {
            return rightHeight + 1;
        }
    }

    public void levelOrderTraversal(Node root) {

        int height = getHeight(root);

        for (int i = 1; i<=height; i++) {
            printLevelOrder(root, i);
        }
    }

    public void printLevelOrder(Node node, int level) {

        if (node == null) {
            return;
        }
        //VERY IMPORTANT
        if (level == 1) {
            System.out.print( " " + node.id);
        } else {
            printLevelOrder(node.left, level-1);
            printLevelOrder(node.right, level-1);
        }
    }

    public void reverseLevelOrderTraversal(Node root) {
        int height = getHeight(root);

        for (int i= height; i>=0; i--) {
            printLevelOrder(root, i);
        }
    }

    public void levelOrderTraversalQueue(Node root) {

        java.util.LinkedList<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            System.out.print(node.id + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public void diagonalTree() {
        Map<Integer, Vector<Integer>> map  = new HashMap<>();
        traverseDiagonalTree(root, 0, map);

        for (Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
            System.out.print(entry.getValue());System.out.println("");
        }
    }

    public void traverseDiagonalTree(Node root, int d, Map<Integer, Vector<Integer>> map) {

        if (root == null) {
            return;
        }

        Vector<Integer> v = map.get(d);

        if (v == null) {
            v = new Vector<>();
            v.add(root.id);
        } else {
            v.add(root.id);
        }

        map.put(d, v);

        traverseDiagonalTree(root.left, d+1, map);

        traverseDiagonalTree(root.right, d, map);
    }

    public void inOrderTraversalIterative(Node root) {

        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node node = root;

        while(node != null) {
            stack.push(node);
            node = node.left;
        }

        while(!stack.isEmpty()) {
            node = stack.pop();

            System.out.print(" " + node.id);
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public int getSize(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = getSize(node.left);
        int rightHeight = getSize(node.right);

        return leftHeight + rightHeight + 1;
    }

    //Leaf order traversal
    public boolean isSame(Node tree1, Node tree2) {

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(tree1);
        stack2.push(tree2);

        while(!stack1.isEmpty() && !stack2.isEmpty()) {


            Node temp1 = stack1.pop();

            while (temp1 != null && !temp1.isLeaf()) {

                if (temp1.left != null) {
                    stack1.push(temp1.left);
                }

                if (temp1.right != null) {
                    stack1.push(temp1.right);
                }

                temp1 = stack1.pop();
            }

            Node temp2 = stack2.pop();

            while (temp2 != null && !temp2.isLeaf()) {
                if (temp2.left != null) {
                    stack2.push(temp2.left);
                }

                if (temp2.right != null) {
                    stack2.push(temp2.right);
                }

                temp2 = stack2.pop();
            }


            if (temp1 == null && temp2!= null) {
                return false;
            }

            if ( temp2 == null && temp1 != null){
                return false;
            }

            if (temp1 != null && temp2 != null) {

                if (temp1 != temp2) {
                    return false;
                }
            }
        }

        return true;
    }

    public int getDiameter(Node node) {
        if (node == null) {
            return 0;
        }

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        int lWidth = getDiameter(node.left);
        int rWidth = getDiameter(node.right);

        return Math.max(lHeight + rHeight + 1, Math.max(rWidth, lWidth));
    }

    public boolean areTreesIdentical(Node n1, Node n2) {

        if (n1 == null && n2 == null) {
            return true;
        }

        return (n1.id == n2.id) && areTreesIdentical(n1.left, n2.left) && areTreesIdentical(n1.right, n2.right);
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

        System.out.println("Level order traversal=");
        binaryTree.levelOrderTraversal(binaryTree.root);

        System.out.println("\nReverse Level order traversal=");
        binaryTree.reverseLevelOrderTraversal(binaryTree.root);

        System.out.println("\nLevel Order Traversal using Queue=");
        binaryTree.levelOrderTraversalQueue(binaryTree.root);

        int height = binaryTree.getHeight(binaryTree.root);
        System.out.println("\nheight: " + height);

        System.out.println("\n Diagonal tree");
        binaryTree.diagonalTree();

        System.out.println("\n Iterative inorder tree: ");
        binaryTree.inOrderTraversalIterative(binaryTree.root);

        System.out.println("\n Size of a tree= " + binaryTree.getSize(binaryTree.root) + "\n");
        System.out.println("Check if leaf traversal of two Binary Trees is same: " + binaryTree.isSame(binaryTree.root, binaryTree.root));

        System.out.println("\n Get diameter of a tree: " + binaryTree.getDiameter(binaryTree.root));
        System.out.println("\n are trees identical: " + binaryTree.areTreesIdentical(binaryTree.root, binaryTree.root));

    }
}