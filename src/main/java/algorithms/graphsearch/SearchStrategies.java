package algorithms.graphsearch;

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
        A.addNeighbor(D);
        B.addNeighbor(C);
        D.addNeighbor(E);
        E.addNeighbor(C);

        System.out.println("BFS starting...");
        Node foundBFS = searchBFS("C", A);
        if (foundBFS != null) {
            System.out.println("Found by BFS: " + foundBFS.getName());
        } else {
            System.out.println("Found nothing with BFS!");
        }

        System.out.println("DFS starting...");
        Node foundDFS = searchDFS("C", A);
        if (foundDFS != null) {
            System.out.println("Found by DFS: " + foundDFS.getName());
        } else {
            System.out.println("Found nothing with DFS!");
        }
    }


    public static Node searchBFS(String targetName, Node start) {
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);

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
            } else {
                for (Node neighbor : currentNode.getNeighbors()) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return null;
    }

    public static Node searchDFS(String targetName, Node start) {
        Set<Node> visited = new HashSet<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(start);
        visited.add(start);

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
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }

        return null;
    }



}
