package graphs.graphsearchcycles;

import java.util.*;

public class CycleDetector {

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

        System.out.println("Cycle detection starting...");
        boolean hasCycle = detectCycle(A);
        if (hasCycle) {
            System.out.println("Graph contains a cycle!");
        } else {
            System.out.println("Graph does not contain any cycles.");
        }

        // Vi tilføjer en forbindelse fra C til A
        C.addNeighbor(A);
        System.out.println("Cycle detection starting yet again...");
        hasCycle = detectCycle(A);
        if (hasCycle) {
            System.out.println("Graph contains a cycle!");
        } else {
            System.out.println("Graph does not contain any cycles.");
        }
    }

    // her laves sættet inPath
    public static boolean detectCycle(Node start) {
        Set<Node> inPath = new HashSet<>();
        return dfsDetectCycle(start, inPath);
    }

    // den rekursive metode
    private static boolean dfsDetectCycle(Node current, Set<Node> inPath) {
        if (inPath.contains(current)) {
            // Vi har stødt på en node vi allerede er på vej igennem -> cyklus!
            return true;
        }

        inPath.add(current);

        for (Node neighbor : current.getNeighbors()) {
            if (dfsDetectCycle(neighbor, inPath)) {
                return true;
            }
        }

        inPath.remove(current); // Når vi backtracker
        return false;
    }
}
