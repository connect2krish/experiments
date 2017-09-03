package net.krishlogic.ds;

public class Node {

    public int id;
    public Node left;
    public Node right;
    public String value;

    public Node(int id) {
        this(id, null);
    }

    public Node(int id, String value) {
        this.id = id;
        this.value = value;
        left = right = null;
    }
}