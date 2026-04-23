package searchandsort;

import java.util.ArrayList;
import java.util.HashSet;

public class SearchComparison {

    // ArrayList.contains() er O(n) - den scanner elementerne ét ad gangen fra starten.
    // HashSet.contains() er O(1) - den udregner hashkoden og hopper direkte til den rigtige bucket.

    // contains (found)   - ArrayList: 3.659.300 ns  |  HashSet: 31.100 ns  (~118x hurtigere)
    // contains (missing) - ArrayList: 3.181.300 ns  |  HashSet:  2.500 ns

    // Når elementet IKKE findes er ArrayList faktisk i worst case - den skal tjekke ALLE
    // 500.000 elementer før den kan konkludere at det ikke er der.
    // HashSet er lige hurtig uanset - found eller missing koster det samme hash-opslag.
    public static void main(String[] args) {
        final int SIZE = 500_000;
        final int EXISTING = 250_000;
        final int MISSING = 999_999;

        // --- Setup ---
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            hashSet.add(i);
        }

        // --- contains (found) ---
        long start = System.nanoTime();
        arrayList.contains(EXISTING);
        long arrayListFound = System.nanoTime() - start;

        start = System.nanoTime();
        hashSet.contains(EXISTING);
        long hashSetFound = System.nanoTime() - start;

        // --- contains (not found) ---
        start = System.nanoTime();
        arrayList.contains(MISSING);
        long arrayListMissing = System.nanoTime() - start;

        start = System.nanoTime();
        hashSet.contains(MISSING);
        long hashSetMissing = System.nanoTime() - start;

        // --- Results ---
        System.out.printf("%-30s %15s %15s%n", "Operation", "ArrayList", "HashSet");
        System.out.println("-".repeat(60));
        System.out.printf("%-30s %12d ns %12d ns%n", "contains (found)",   arrayListFound,   hashSetFound);
        System.out.printf("%-30s %12d ns %12d ns%n", "contains (missing)", arrayListMissing, hashSetMissing);
    }
}