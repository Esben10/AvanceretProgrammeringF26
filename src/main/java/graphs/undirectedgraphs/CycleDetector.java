package graphs.undirectedgraphs;

import java.util.HashSet;
import java.util.Set;

public class CycleDetector {

    public static void main(String[] args) {
        // Vi bygger en simpel urettet graf:
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");

        A.addUndirectedNeighbor(B);
        A.addUndirectedNeighbor(C);
        B.addUndirectedNeighbor(D);
        C.addUndirectedNeighbor(D);

        System.out.println("Cycle detection starting...");
        boolean hasCycle = detectCycleUndirected(A);

        if (hasCycle) {
            System.out.println("Graph contains a cycle!");
        } else {
            System.out.println("Graph does not contain any cycles.");
        }
    }

    public static boolean detectCycle(Node start) {
        Set<Node> visited = new HashSet<>();
        Set<Node> inPath = new HashSet<>();
        return dfsDetectCycleUndirected(start, null, visited);
    }

    public static boolean detectCycleUndirected(Node start) {
        Set<Node> visited = new HashSet<>();
        return dfsDetectCycleUndirected(start, null, visited);
    }

    private static boolean dfsDetectCycleUndirected(Node current, Node parent, Set<Node> visited) {
        visited.add(current);

        for (Node neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                if (dfsDetectCycleUndirected(neighbor, current, visited)) {
                    return true;
                }
            } else if (!neighbor.equals(parent)) {
                // Nabo er besøgt, men ikke parent → cyklus!
                return true;
            }
        }

        return false;
    }

}
