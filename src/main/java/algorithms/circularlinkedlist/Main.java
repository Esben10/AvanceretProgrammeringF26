package algorithms.circularlinkedlist;



import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node list = ListFactory.buildList(1, 2, 3, 4, 5);
        System.out.println("Has cycle: " + hasCycle(list));   // false

        Node circularList = ListFactory.buildListWithCycle();
        System.out.println("Has cycle: " + hasCycle(circularList)); // true
    }

    public static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
