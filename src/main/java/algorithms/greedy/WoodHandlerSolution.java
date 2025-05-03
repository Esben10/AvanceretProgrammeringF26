package algorithms.greedy;

import java.util.ArrayList;
import java.util.List;

public class WoodHandlerSolution {


    public static void main(String[] args) {
        System.out.println("17 meter: " + calculateWood(17));
        System.out.println("13 meter: " + calculateWood(13));
        System.out.println("10 meter: " + calculateWood(10));
    }

    static int[] lengths = {7, 5, 2};


    public static List<Integer> calculateWood(int target) {
        int remaining = target;
        List<Integer> result = new ArrayList<>();

        for (int l : lengths) {
            int count = remaining / l;
            if (count > 0) {
                for(int i = 0; i < count; i++){
                    result.add(l);
                }
                remaining -= count * l;

            }
        }

        if (remaining > 0) {
            result.add(lengths[lengths.length-1]);
        }
        return result;
    }

    public static List<Integer> calculateWoodPrecisely(int target) {
        int remaining = target;
        List<Integer> result = new ArrayList<>();

        for (int l : lengths) {
            int count = remaining / l;
            if (count > 0) {
                for (int i = 0; i < count; i++) {
                    result.add(l);
                }
                remaining -= count * l; // <- HER er det vigtige fix
            }
        }

        // Vi vil kun returnere listen hvis vi har et præcist resultat
        if (remaining == 0) {
            return result;
        }

        return null;
    }

}
