package algorithms.floydexample;

public class TraversingArrays {

    public static void naiveWalk(int[] array) {
        int current = array[0];
        while (current < array.length) {
            System.out.print(array[current] + " → ");
            current = array[current];
        }
        System.out.println("null");
    }


    public static boolean hasCycle(int[] array) {
        int slow = 0;
        int fast = 0;

        while (true) {
            // Første hop for slow
            if (slow < 0 || slow >= array.length) return false;
            slow = array[slow];

            // Første hop for fast
            if (fast < 0 || fast >= array.length) return false;
            fast = array[fast];

            // Andet hop for fast
            if (fast < 0 || fast >= array.length) return false;
            fast = array[fast];

            // Check om de mødes
            if (slow == fast) return true;
        }


    }



}
