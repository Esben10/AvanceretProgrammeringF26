package algorithms.reversedlinkedlist;


public class Main {

    public static void main(String[] args) {

      Node head = ListFactory.buildList(1, 2, 3, 4, 5);
        System.out.println("LinkedList: " + head.toString());
        //head = reverseList(head);
        System.out.println("LinkedList reversed: " + head.toString());
    }
}
