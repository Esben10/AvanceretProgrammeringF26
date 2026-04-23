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
            // Hvis slow er hoppet udenfor array er der ingen cyklus
            if (slow >= array.length) return false;
            // Slow hopper én gang
            slow = array[slow];

            // Hvis fast er hoppet udenfor array er der ingen cyklus
            if (fast >= array.length) return false;
            // Fast hopper én gang
            fast = array[fast];

            // Hvis fast nu er hoppet udenfor array er der ingen cyklus
            if (fast >= array.length) return false;
            // Fast hopper endnu én gang
            fast = array[fast];

            // Check om de mødes
            if (slow == fast) return true;
        }


    }



}
