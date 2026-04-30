package algorithms.reversedlinkedlistsolution;

public class Main {

    public static void main(String[] args) {

        Node head = ListFactory.buildList(1, 2, 3, 4, 5);
        System.out.println("LinkedList: " + head.toString());

        head = reverseList(head);
        System.out.println("LinkedList reversed: " + head.toString());
    }

    public static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
