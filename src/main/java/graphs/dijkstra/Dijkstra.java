package graphs.dijkstra;

import java.util.*;

public class Dijkstra {

    public static void main(String[] args) {
        WeightedNode S = new WeightedNode("S");
        WeightedNode A = new WeightedNode("A");
        WeightedNode B = new WeightedNode("B");
        WeightedNode C = new WeightedNode("C");
        WeightedNode D = new WeightedNode("D");
        WeightedNode E = new WeightedNode("E");
        WeightedNode F = new WeightedNode("F");
        WeightedNode G = new WeightedNode("G");
        WeightedNode H = new WeightedNode("H");
        WeightedNode I = new WeightedNode("I");
        WeightedNode J = new WeightedNode("J");
        WeightedNode K = new WeightedNode("K");
        WeightedNode L = new WeightedNode("L");
        WeightedNode M = new WeightedNode("M");

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


    public static void findShortestPath(WeightedNode source, WeightedNode destination) {
        // En node og den node vi kom fra. Skal bruges til at printe vejen fra start til slut
        Map<WeightedNode, WeightedNode> prev = new HashMap<>();

        // Gemmer den billigste kendte dist til hver node
        Map<WeightedNode, Integer> dist = new HashMap<>();

        // Noder vi har besøgt og ikke skal afsøge igen
        Set<WeightedNode> visited = new HashSet<>();

        // Køen sorterer selv efter dist fordi NodeWithDist implementerer Comparable
        PriorityQueue<NodeWithDist> queue = new PriorityQueue<>();

        // Startnoden er 0 væk fra sig selv
        queue.add(new NodeWithDist(source, 0));
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

                // Currents afstand til startnode + currents afstand til nabo
                int newDist = current.dist + weight;

                // Opdater kun hvis vi har fundet en billigere vej
                if (newDist < dist.getOrDefault(next, Integer.MAX_VALUE)) {
                    dist.put(next, newDist);
                    prev.put(next, current.node);
                    // Vi putter en ny NodeWithDist i køen i stedet for at opdatere den eksisterende.
                    // Ideelt ville vi tjekke om noden allerede er i køen og opdatere dens dist,
                    // men Java's PriorityQueue understøtter ikke det effektivt (contains() og remove() er O(n)).
                    // I stedet bruger vi dist-mappet til at undgå at putte en dårligere vej i køen overhovedet.
                    // Hvis en forældet NodeWithDist alligevel popper ud, fanger visited-tjekket den.
                    queue.add(new NodeWithDist(next, newDist));
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

    // Hjælpeklasse der pakker en node og dens afstand fra startnoden sammen
    // så køen selv kan sortere uden at slå op i et separat dist-map
    // Vi kan ikke bare have dist som attribut på WeighedNode fordi det der kunne være flere algoritmer
    // der kørte samtidig med forskellige startnoder og dermed forskellige distancer
    private static class NodeWithDist implements Comparable<NodeWithDist> {
        WeightedNode node;
        int dist;

        public NodeWithDist(WeightedNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(NodeWithDist other) {
            return Integer.compare(this.dist, other.dist);
        }
    }
}