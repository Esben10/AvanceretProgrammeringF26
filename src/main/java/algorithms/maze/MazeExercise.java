package algorithms.maze;

public class MazeExercise {
    static final int N = 4;

    static int[][] maze = {
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 1, 0, 1}
    };

    static int[][] path = new int[N][N];

    public static void main(String[] args) {
        if (solveMaze(0, 0)) {
            printPath();
        } else {
            System.out.println("Ingen løsning fundet.");
        }
    }

    static boolean solveMaze(int row, int col) {
        // Udenfor labyrintens grænser?
        if (row < 0 || col < 0 || row >= N || col >= N) return false;
        // Mur?
        if (maze[row][col] == 0) return false;
        // Allerede besøgt?
        if (path[row][col] == 1) return false;

        // Markér feltet som del af stien
        path[row][col] = 1;

        // Nået målet?
        if (row == N - 1 && col == N - 1) return true;

        // Prøv alle fire retninger: ned, højre, op, venstre
        if (solveMaze(row + 1, col)) return true;
        if (solveMaze(row, col + 1)) return true;
        if (solveMaze(row - 1, col)) return true;
        if (solveMaze(row, col - 1)) return true;

        // Ingen retning virkede — backtrack
        path[row][col] = 0;
        return false;
    }

    static void printPath() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }
}
