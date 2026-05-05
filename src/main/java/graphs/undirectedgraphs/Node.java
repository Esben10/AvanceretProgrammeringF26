package graphs.undirectedgraphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<Node> neighbors;

    public Node(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    // Urettet kant - når A tilføjer B som ven, tilføjes A også til B
    public void addNeighbor(Node other) {
        this.neighbors.add(other);
        other.neighbors.add(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" er ven med: ");
        for (Node neighbor : neighbors) {
            sb.append("\n").append(neighbor.getName());
        }
        return sb.toString();
    }


}