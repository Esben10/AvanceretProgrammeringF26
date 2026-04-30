package algorithms.circularlinkedlist;

public class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
    }

    public String toString(){
        String result = "" + value;
        if (next != null){
            result += " -> " + next.toString();
        }
        return result;
    }
}
