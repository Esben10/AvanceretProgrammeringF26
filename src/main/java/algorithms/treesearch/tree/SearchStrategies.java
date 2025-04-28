package algorithms.treesearch.tree;


import java.util.*;

public class SearchStrategies {

    public static void main(String[] args) {

        Node root = new Node(10); // root
        Node newChild = root.addChild(5); // root first child
        root.addChild(7); // root second child
        root.addChild(15); // root third child
        Node newChildChild = newChild.addChild(115); // root first child -> child
        Node newChildChildChild = newChildChild.addChild(207); // root first child -> child -> child
        Node newChildChildChildChild = newChildChild.addChild(500);

        Node foundNode = searchBFS(500, root); // BFS search
        System.out.println("BFS starting..");
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }

        System.out.println("DFS starting..");
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }
    }

    public static Node searchBFS(int value, Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root); // first we add the root node as the
        // only member of the queue

        while(!queue.isEmpty()) {

            System.out.print("Current queue: ");
            for (Node item: queue) {
                System.out.print(item.getValue() + " ");
            }
            System.out.println();

            Node currentNode = queue.remove(); // we remove the first node in queue
            // and save it as currentNode

            // check for "win" condition
            if (currentNode.getValue() == value) {
                System.out.println("Finished searching!");
                return currentNode;
            }
            // if we did not find the value we are looking for..
            // add all children to the queue in order
            else {
                queue.addAll(currentNode.getChildren());
            }
        }

        return null;
    }

    public static Node searchDFS(int value, Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root); // Bemærk: push, ikke add

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop(); // pop fra toppen

            if (currentNode.getValue() == value) {
                System.out.println("Finished searching!");
                return currentNode;
            } else {
                List<Node> children = currentNode.getChildren();
                // For ikke at ændre rækkefølgen for meget, kan du evt. tilføje baglæns
                Collections.reverse(children);
                stack.addAll(children);
            }
        }
        return null;
    }



}