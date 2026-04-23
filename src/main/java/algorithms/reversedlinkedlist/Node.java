package algorithms.reversedlinkedlist;

class Node {
    int value;
    Node next = null;

    Node(int value) {
        this.value = value;
    }

    public String toString(){
        return value + " -> " + next;
    }

}
