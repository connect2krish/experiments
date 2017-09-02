package net.krishlogic.ds;

public class Node {

    public int id;
    public Node left;
    public Node right;
    public String value;

    public Node(int id) {
        left = right = null;
        value = null;
        this.id = id;
    }
}