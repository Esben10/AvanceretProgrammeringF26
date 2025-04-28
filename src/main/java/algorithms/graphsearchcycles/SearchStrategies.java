package algorithms.graphsearchcycles;

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
        E.addNeighbor(C); // Ekstra forbindelse skaber mulighed for cyklus (men her ingen rigtig rundtur)

        System.out.println("Cycle detection starting...");
        boolean hasCycle = detectCycle(A);
        if (hasCycle) {
            System.out.println("Graph contains a cycle!");
        } else {
            System.out.println("Graph does not contain any cycles.");
        }
    }

    public static boolean detectCycle(Node start) {
        Set<Node> visited = new HashSet<>();
        Set<Node> inPath = new HashSet<>();
        return dfsDetectCycle(start, visited, inPath);
    }

    private static boolean dfsDetectCycle(Node current, Set<Node> visited, Set<Node> inPath) {
        if (inPath.contains(current)) {
            // Vi har stødt på en node vi allerede er på vej igennem -> cyklus!
            return true;
        }
        if (visited.contains(current)) {
            // Allerede besøgt og afsluttet → ingen grund til at tjekke igen
            return false;
        }

        visited.add(current);
        inPath.add(current);

        for (Node neighbor : current.getNeighbors()) {
            if (dfsDetectCycle(neighbor, visited, inPath)) {
                return true;
            }
        }

        inPath.remove(current); // Når vi backtracker
        return false;
    }
}
