package graphs.astar;

import java.util.HashMap;
import java.util.Map;

public class WeightedNode {
    private String name;
    private int row;
    private int col;
    // Kanterne er vægtede, så vi gemmer afstanden til naboerne i et map
    private Map<WeightedNode, Integer> neighbors;

    public WeightedNode(String name, int row, int col) {
        this.name = name;
        this.row = row;
        this.col = col;
        this.neighbors = new HashMap<>();
    }

    public String getName() { return name; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public Map<WeightedNode, Integer> getNeighbors() { return neighbors; }

    public void addNeighbor(WeightedNode neighbor, int weight) {
        neighbors.put(neighbor, weight);
    }
}