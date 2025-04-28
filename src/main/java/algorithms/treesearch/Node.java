package algorithms.treesearch;



import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private List<Node> children;

    public Node(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public int getValue() {
        return this.value;
    }

    public List<Node> getChildren() {
        return this.children;
    }

    public Node addChild(int value) {
        Node newChild = new Node(value);
        children.add(newChild);
        return newChild;
    }


}