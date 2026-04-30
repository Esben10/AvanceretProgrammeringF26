package algorithms.reversedlinkedlist;


public class Main {

    public static void main(String[] args) {
        Node head = ListFactory.buildList(1, 5, 7, 12, 17);
        System.out.println("LinkedList: " + head);
        head = reverseList(head);
        System.out.println("LinkedList reversed: " + head);
    }

    public static Node reverseList(Node n) {
        Node prev = null;
        Node current = n;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
