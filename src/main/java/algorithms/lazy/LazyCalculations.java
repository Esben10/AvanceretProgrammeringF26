package algorithms.lazy;

import java.util.HashMap;
import java.util.Map;

public class LazyCalculations {

    static int lazyCounter = 0;
    static int eagerCounter = 0;

    //  LAZY (beregn kun når nødvendigt) 

    // Cache-maps: gemmer tidligere beregnede resultater så vi ikke regner det samme to gange
    static Map<Integer, Long> memoFactorial = new HashMap<>();
    static Map<Integer, Long> memoSum = new HashMap<>();

    // Beregner n! (fakultet) rekursivt, men gemmer resultatet i memoFactorial.
    // Næste gang samme n bruges, returneres svaret direkte fra cachen.
    public static long lazyFactorial(int n) {
        if (memoFactorial.containsKey(n)) {
            return memoFactorial.get(n); // allerede beregnet — returnér fra cache
        }
        lazyCounter++;
        long result = (n == 0 || n == 1) ? 1 : n * lazyFactorial(n - 1);
        memoFactorial.put(n, result); // gem resultatet til næste gang
        return result;
    }


    // Beregner summen 1 + 2 + ... + n rekursivt med caching.
    // Hvis lazySum(5) er kaldt før, kender vi allerede lazySum(3) fra cachen.
    public static long lazySum(int n) {
        if (memoSum.containsKey(n)) {
            return memoSum.get(n); // allerede beregnet — returnér fra cache
        }
        lazyCounter++;
        long result = (n <= 0) ? 0 : n + lazySum(n - 1);
        memoSum.put(n, result); // gem resultatet til næste gang
        return result;
    }


    //  EAGER (beregn alt på forhånd i init)

    static final int MAX = 20;
    // Opslagstabeller fyldt af init() — alle værdier 0–MAX er forudberegnet
    static Map<Integer, Long> eagerFactorials = new HashMap<>();
    static Map<Integer, Long> eagerSums = new HashMap<>();

    // Forberegner fakultet og sum for alle tal fra 0 til MAX.
    // Betales som opstartsomkostning én gang, så alle efterfølgende opslag er O(1).
    public static void init() {
        long f = 1;
        long s = 0;
        for (int i = 1; i <= MAX; i++) {
            eagerCounter++;
            f *= i;       // f er nu i!
            s += i;       // s er nu 1+2+...+i
            eagerFactorials.put(i, f);
            eagerSums.put(i, s);
        }
        eagerFactorials.put(0, 1L); // 0! = 1 pr. definition
        eagerSums.put(0, 0L);
    }

    

    // Slår fakultet op i den forudberegnede tabel — ingen beregning, kun et Map.get()
    public static long eagerFactorial(int n) {
        return eagerFactorials.getOrDefault(n, -1L);
    }

    // Slår sum op i den forudberegnede tabel — ingen beregning, kun et Map.get()
    public static long eagerSum(int n) {
        return eagerSums.getOrDefault(n, -1L);
    }

   

    public static void main(String[] args) {
        System.out.println("=== Lazy factorial ===");
        System.out.println("lazyFactorial(5) = " + lazyFactorial(5));
        System.out.println("lazyFactorial(3) = " + lazyFactorial(3)); // fra cache
        System.out.println("Beregninger udført: " + lazyCounter);

        lazyCounter = 0;
        System.out.println("\n=== Lazy sum ===");
        System.out.println("lazySum(5) = " + lazySum(5));
        System.out.println("lazySum(3) = " + lazySum(3)); // fra cache
        System.out.println("Beregninger udført: " + lazyCounter);

        System.out.println("\n=== Eager (efter init) ===");
        long start = System.nanoTime();
        init();
        long initTime = System.nanoTime() - start;
        System.out.println("init() beregninger: " + eagerCounter + " (tid: " + initTime / 1000 + " µs)");

        start = System.nanoTime();
        System.out.println("eagerFactorial(5) = " + eagerFactorial(5));
        System.out.println("eagerSum(5) = " + eagerSum(5));
        long lookupTime = System.nanoTime() - start;
        System.out.println("Opslag tid: " + lookupTime + " ns");
    }
}

