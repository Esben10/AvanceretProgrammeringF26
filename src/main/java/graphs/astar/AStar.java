package graphs.astar;


import java.util.*;

public class AStar {

    public static void main(String[] args) {
        WeightedNode S = new WeightedNode("S", 0, 0);
        WeightedNode A = new WeightedNode("A", 0, 1);
        WeightedNode B = new WeightedNode("B", 1, 0);
        WeightedNode C = new WeightedNode("C", 0, 2);
        WeightedNode D = new WeightedNode("D", 1, 1);
        WeightedNode E = new WeightedNode("E", 1, 2);
        WeightedNode F = new WeightedNode("F", 2, 0);
        WeightedNode G = new WeightedNode("G", 0, 3);
        WeightedNode H = new WeightedNode("H", 1, 3);
        WeightedNode I = new WeightedNode("I", 2, 2);
        WeightedNode J = new WeightedNode("J", 0, 4);
        WeightedNode K = new WeightedNode("K", 1, 4);
        WeightedNode L = new WeightedNode("L", 2, 3);
        WeightedNode M = new WeightedNode("M", 2, 4);

        S.addNeighbor(A, 1);
        S.addNeighbor(B, 3);
        S.addNeighbor(C, 2);
        A.addNeighbor(D, 2);
        B.addNeighbor(D, 5);
        B.addNeighbor(E, 4);
        C.addNeighbor(E, 1);
        C.addNeighbor(F, 3);
        D.addNeighbor(G, 3);
        E.addNeighbor(G, 6);
        E.addNeighbor(H, 3);
        F.addNeighbor(I, 2);
        G.addNeighbor(H, 1);
        G.addNeighbor(J, 7);
        H.addNeighbor(J, 2);
        H.addNeighbor(K, 5);
        I.addNeighbor(K, 3);
        I.addNeighbor(L, 4);
        J.addNeighbor(M, 3);
        K.addNeighbor(M, 4);
        L.addNeighbor(M, 8);

        findShortestPath(S, M);
    }

    // Manhattan-afstand som heuristik
    private static int heuristic(WeightedNode node, WeightedNode destination) {
        return Math.abs(destination.getRow() - node.getRow())
                + Math.abs(destination.getCol() - node.getCol());
    }

    public static void findShortestPath(WeightedNode source, WeightedNode destination) {
        // En node og den node vi kom fra. Skal bruges til at printe vejen fra start til slut
        Map<WeightedNode, WeightedNode> prev = new HashMap<>();

        // Gemmer den billigste kendte g(n) til hver node
        Map<WeightedNode, Integer> dist = new HashMap<>();

        // Noder vi har besøgt og ikke skal afsøge igen
        Set<WeightedNode> visited = new HashSet<>();

        // Køen sorterer selv efter f(n) = g(n) + h(n) fordi NodeWithDist implementerer Comparable
        PriorityQueue<NodeWithDist> queue = new PriorityQueue<>();

        // Startnoden er 0 væk fra sig selv
        queue.add(new NodeWithDist(source, 0, heuristic(source, destination)));
        dist.put(source, 0);

        while (!queue.isEmpty()) {
            NodeWithDist current = queue.poll();

            // Vi bryder ud af løkken hvis vi finder vores mål-node
            if (current.node.equals(destination)) break;

            // Vi går til næste iteration hvis vi allerede har besøgt denne node
            if (visited.contains(current.node)) continue;

            // Vi er i gang med at undersøge current, så den skal i visited
            // så vi ikke vender tilbage til den senere
            visited.add(current.node);

            // Vi henter alle nodens naboer ud
            for (Map.Entry<WeightedNode, Integer> entry : current.node.getNeighbors().entrySet()) {
                WeightedNode next = entry.getKey();
                int weight = entry.getValue();

                // Hvis det er en node vi før har besøgt, går vi til næste iteration
                if (visited.contains(next)) continue;

                // g(n): currents afstand til startnode + currents afstand til nabo
                int newDist = current.gCost + weight;

                // Opdater kun hvis vi har fundet en billigere vej
                if (newDist < dist.getOrDefault(next, Integer.MAX_VALUE)) {
                    dist.put(next, newDist);
                    prev.put(next, current.node);
                    // f(n) = g(n) + h(n)
                    queue.add(new NodeWithDist(next, newDist, heuristic(next, destination)));
                }
            }
        }

        // Rekonstruer stien via prev
        List<String> path = new ArrayList<>();
        WeightedNode step = destination;
        while (step != null) {
            path.add(0, step.getName());
            step = prev.get(step);
        }

        System.out.println("Korteste vej: " + path);
        System.out.println("Samlet dist: " + dist.get(destination));
    }

    // Hjælpeklasse der pakker en node, g(n) og f(n) sammen
    // så køen kan sortere efter f(n) = g(n) + h(n)
    // Vi kan ikke bare have dist som attribut på WeightedNode fordi der kunne være
    // flere algoritmer der kørte samtidig med forskellige startnoder
    // og dermed forskellige distancer til den samme node
    private static class NodeWithDist implements Comparable<NodeWithDist> {
        WeightedNode node;
        int gCost;  // afstand fra start
        int fCost;  // g(n) + h(n)

        public NodeWithDist(WeightedNode node, int gCost, int hCost) {
            this.node = node;
            this.gCost = gCost;
            this.fCost = gCost + hCost;
        }

        @Override
        public int compareTo(NodeWithDist other) {
            return Integer.compare(this.fCost, other.fCost);
        }
    }
}