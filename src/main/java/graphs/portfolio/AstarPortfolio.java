package graphs.portfolio;

import java.util.*;

public class AstarPortfolio {

    // 0 = åben vej, 1 = mur
    static int[][] grid = {
        {0,0,0,0,0,0,0,0,0,0},  // row 0 — Nordby(0,0), Bjergby(0,9)
        {0,1,1,0,1,0,1,1,0,0},  // row 1
        {0,0,1,0,0,0,1,0,0,0},  // row 2 — Skovby(2,5)
        {1,0,1,1,1,0,0,1,0,1},  // row 3
        {0,0,0,0,0,0,0,0,0,0},  // row 4 — Vestby(4,0), Midtby(4,5), Østby(4,9)
        {0,1,0,1,1,0,1,0,1,0},  // row 5
        {0,0,0,0,0,0,0,0,0,0},  // row 6 — Søby(6,2)
        {1,0,1,0,1,0,1,0,1,0},  // row 7
        {0,0,0,0,0,0,0,0,0,0},  // row 8
        {0,0,0,0,0,0,0,0,0,0},  // row 9 — Sydby(9,5)
    };

    static final int ROWS = 10, COLS = 10;

    static final Map<String, int[]> CITIES = new LinkedHashMap<>();
    static {
        CITIES.put("Nordby",  new int[]{0, 0});
        CITIES.put("Bjergby", new int[]{0, 9});
        CITIES.put("Skovby",  new int[]{2, 5});
        CITIES.put("Vestby",  new int[]{4, 0});
        CITIES.put("Midtby",  new int[]{4, 5});
        CITIES.put("Østby",   new int[]{4, 9});
        CITIES.put("Søby",    new int[]{6, 2});
        CITIES.put("Sydby",   new int[]{9, 5});
    }

    public static void main(String[] args) {
        GridNode[][] nodes = buildGrid();

        GridNode source = nodes[0][0];  // Nordby
        GridNode dest   = nodes[9][5];  // Sydby

        System.out.println("=== A*: Korteste vej fra " + source.name + " til " + dest.name + " ===");
        System.out.println("Heuristik: Manhattan-afstand til " + dest.name);
        System.out.println("g = skridt fra start  |  h = heuristik til mål  |  f = g + h\n");

        printGrid(nodes, null, new HashSet<>(), new HashSet<>(), Collections.emptyList());
        findShortestPath(nodes, source, dest);
    }

    static GridNode[][] buildGrid() {
        GridNode[][] nodes = new GridNode[ROWS][COLS];
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++)
                if (grid[r][c] == 0)
                    nodes[r][c] = new GridNode(r, c);

        for (Map.Entry<String, int[]> e : CITIES.entrySet()) {
            int[] pos = e.getValue();
            if (nodes[pos[0]][pos[1]] != null)
                nodes[pos[0]][pos[1]].name = e.getKey();
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for (int r = 0; r < ROWS; r++)
            for (int c = 0; c < COLS; c++) {
                if (nodes[r][c] == null) continue;
                for (int[] d : dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < ROWS && nc >= 0 && nc < COLS && nodes[nr][nc] != null)
                        nodes[r][c].addNeighbor(nodes[nr][nc]);
                }
            }
        return nodes;
    }

    // Manhattan-afstand: god heuristik for grid uden diagonale skridt
    static int heuristic(GridNode node, GridNode dest) {
        return Math.abs(dest.row - node.row) + Math.abs(dest.col - node.col);
    }

    static void findShortestPath(GridNode[][] nodes, GridNode source, GridNode dest) {
        Map<GridNode, GridNode> prev    = new HashMap<>();
        Map<GridNode, Integer>  gCosts  = new HashMap<>();
        Set<GridNode>           visited = new HashSet<>();
        PriorityQueue<NodeEntry> queue  = new PriorityQueue<>();

        gCosts.put(source, 0);
        queue.add(new NodeEntry(source, 0, heuristic(source, dest)));

        int step = 1;
        while (!queue.isEmpty()) {
            NodeEntry current = queue.poll();
            if (visited.contains(current.node)) continue;

            if (current.node.equals(dest)) {
                System.out.println("--- Step " + step + ": Nåede " + dest.name + "! ---\n");
                break;
            }
            visited.add(current.node);

            String label = label(current.node);
            int h = heuristic(current.node, dest);
            System.out.println("--- Step " + step++ + ": Besøger " + label
                + " (g=" + current.gCost + " h=" + h + " f=" + current.fCost
                + ") — laveste fCost i køen ---");

            for (GridNode next : current.node.neighbors) {
                if (visited.contains(next)) continue;
                int ng = current.gCost + 1;
                if (ng < gCosts.getOrDefault(next, Integer.MAX_VALUE)) {
                    gCosts.put(next, ng);
                    prev.put(next, current.node);
                    int nh = heuristic(next, dest);
                    queue.add(new NodeEntry(next, ng, nh));
                    System.out.println("  Tilføjer " + label(next)
                        + " til kø: g=" + ng + " h=" + nh + " f=" + (ng + nh));
                }
            }

            Set<GridNode> inQueue = new HashSet<>();
            for (NodeEntry e : queue) inQueue.add(e.node);
            printGrid(nodes, current.node, visited, inQueue, Collections.emptyList());
        }

        // Rekonstruer sti
        List<GridNode> path = new ArrayList<>();
        GridNode s = dest;
        while (s != null) { path.add(0, s); s = prev.get(s); }

        printGrid(nodes, null, visited, new HashSet<>(), path);

        List<String> names = new ArrayList<>();
        for (GridNode n : path) names.add(label(n));

        System.out.println("=== Resultat ===");
        System.out.println("Korteste vej: " + String.join(" → ", names));
        System.out.println("Antal skridt: " + (path.size() - 1));
        System.out.println("Celler udforsket: " + visited.size()
            + " (A* springer mange celler over takket være heuristikken)");
    }

    static String label(GridNode n) {
        return n.name != null ? n.name : "(" + n.row + "," + n.col + ")";
    }

    // Udskriv grid-tilstand i konsollen
    static void printGrid(GridNode[][] nodes, GridNode current,
                           Set<GridNode> visited, Set<GridNode> inQueue, List<GridNode> path) {
        Set<GridNode> pathSet = new HashSet<>(path);
        System.out.print("  ");
        for (int c = 0; c < COLS; c++) System.out.print(c + " ");
        System.out.println();

        for (int r = 0; r < ROWS; r++) {
            System.out.print(r + " ");
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    System.out.print("# ");
                } else {
                    GridNode n = nodes[r][c];
                    char ch;
                    if (n.equals(current))         ch = 'X';
                    else if (pathSet.contains(n))  ch = '@';
                    else if (visited.contains(n))  ch = '*';
                    else if (inQueue.contains(n))  ch = '?';
                    else if (n.name != null)        ch = Character.toUpperCase(n.name.charAt(0));
                    else                            ch = '.';
                    System.out.print(ch + " ");
                }
            }
            System.out.println();
        }
        System.out.println("  X=besøger  *=besøgt  ?=i kø  @=korteste vej  #=mur");
        System.out.println();
    }

    // ── Indre klasser ────────────────────────────────────────────────────────

    static class GridNode {
        int row, col;
        String name;
        List<GridNode> neighbors = new ArrayList<>();

        GridNode(int row, int col) { this.row = row; this.col = col; }
        void addNeighbor(GridNode n) { neighbors.add(n); }
    }

    static class NodeEntry implements Comparable<NodeEntry> {
        GridNode node;
        int gCost, fCost;

        NodeEntry(GridNode node, int gCost, int hCost) {
            this.node  = node;
            this.gCost = gCost;
            this.fCost = gCost + hCost;
        }

        @Override
        public int compareTo(NodeEntry o) {
            return Integer.compare(this.fCost, o.fCost);
        }
    }
}
