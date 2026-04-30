package graphs.graphsearch;

import java.util.*;

public class SearchStrategies {

    public static void main(String[] args) {
        // Vi bygger en simpel graf:
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");

        A.addNeighbor(B);
        A.addNeighbor(C);
        A.addNeighbor(D);
        C.addNeighbor(E);
        // Hvad sker der hvis vi lade E have A som nabo?
       // E.addNeighbor(A);

        System.out.println("BFS starting...");
        Node foundBFS = searchBFS("F", A);
        if (foundBFS != null) {
            System.out.println("Found by BFS: " + foundBFS.getName());
        } else {
            System.out.println("Found nothing with BFS!");
        }

        System.out.println("DFS starting...");
        Node foundDFS = searchDFS("F", A);
        if (foundDFS != null) {
            System.out.println("Found by DFS: " + foundDFS.getName());
        } else {
            System.out.println("Found nothing with DFS!");
        }
    }


    public static Node searchBFS(String targetName, Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            System.out.print("Current queue: ");
            for (Node item : queue) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();

            Node currentNode = queue.remove();

            if (currentNode.getName().equals(targetName)) {
                System.out.println("Finished searching!");
                return currentNode;
            }
            else queue.addAll(currentNode.getNeighbors());
        }
        return null;
    }

    public static Node searchDFS(String targetName, Node start) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {

            System.out.print("Current stack: ");
            for (Node item : stack) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();

            Node currentNode = stack.pop();

            if (currentNode.getName().equals(targetName)) {
                System.out.println("Finished searching!");
                return currentNode;
            } else {
                for (Node neighbor : currentNode.getNeighbors()) {
                    stack.push(neighbor);
                }
            }

        }

        return null;
    }



}
