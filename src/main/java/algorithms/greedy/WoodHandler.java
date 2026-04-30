package algorithms.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WoodHandler {

    static final int[] LENGTHS = {7, 5, 2};

    // Grådig: vælg altid det størst mulige stykke der passer
    public static List<Integer> calculateWood(int target) {
        List<Integer> result = new ArrayList<>();
        int remaining = target;
        for (int length : LENGTHS) {
            while (remaining >= length) {
                result.add(length);
                remaining -= length;
            }
        }
        // Hvis vi ikke kan ramme præcist, returnér det vi har (tættest på)
        return result;
    }

    // Lazy: cache tidligere beregninger
    static Map<Integer, List<Integer>> cache = new HashMap<>();

    public static List<Integer> calculateWoodLazy(int target) {
        if (cache.containsKey(target)) {
            return cache.get(target);
        }
        List<Integer> result = calculateWood(target);
        cache.put(target, result);
        return result;
    }

    // Backtracking: find løsningen med færrest stykker
    public static List<Integer> calculateWoodBacktrack(int target) {
        List<Integer> best = new ArrayList<>();
        backtrack(target, new ArrayList<>(), best);
        return best;
    }

    private static void backtrack(int remaining, List<Integer> current, List<Integer> best) {
        if (remaining == 0) {
            if (best.isEmpty() || current.size() < best.size()) {
                best.clear();
                best.addAll(current);
            }
            return;
        }
        for (int length : LENGTHS) {
            if (length <= remaining) {
                current.add(length);
                backtrack(remaining - length, current, best);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Grådig ===");
        System.out.println("calculateWood(11): " + calculateWood(11));   // [7, 2, 2]
        System.out.println("calculateWood(12): " + calculateWood(12));   // [7, 5]
        System.out.println("calculateWood(13): " + calculateWood(13));   // [7, 5, 2] - tættest på (rest=1)
        System.out.println("calculateWood(10): " + calculateWood(10));   // [7, 2] - rest=1

        System.out.println("\n=== Lazy (med cache) ===");
        System.out.println("calculateWoodLazy(11): " + calculateWoodLazy(11));
        System.out.println("calculateWoodLazy(11): " + calculateWoodLazy(11)); // fra cache

        System.out.println("\n=== Backtracking (færrest stykker) ===");
        System.out.println("calculateWoodBacktrack(10): " + calculateWoodBacktrack(10)); // [5, 5]
        System.out.println("calculateWoodBacktrack(14): " + calculateWoodBacktrack(14)); // [7, 7]
        System.out.println("calculateWoodBacktrack(11): " + calculateWoodBacktrack(11)); // [7, 2, 2]
    }
}
