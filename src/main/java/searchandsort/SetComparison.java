package searchandsort;

import searchandsort.entities.Product;

import java.util.HashSet;
import java.util.TreeSet;

public class SetComparison {


    // HashSet bruger hashing og har gennemsnitlig O(1) tid for add, remove og contains.
    // TreeSet er baseret på et balanceret træ og har O(log n) for de samme operationer.

    // add        - HashSet: 40.644.600 ns  |  TreeSet: 33.886.100 ns  (~TreeSet lidt hurtigere her)
    // contains   - HashSet:     17.800 ns  |  TreeSet:     42.400 ns  (~2.4x hurtigere)
    // remove     - HashSet:      8.100 ns  |  TreeSet:     15.800 ns  (~2x hurtigere)

    // contains og remove følger teorien:
    // HashSet er hurtigere fordi den kan slå direkte op via hashkode,
    // mens TreeSet skal navigere i et træ (log n trin).

    // add-operationen er lidt overraskende:
    // TreeSet er hurtigere i dette tilfælde, selvom HashSet normalt burde være O(1).
    // Det skyldes sandsynligvis at HashSet skal resize og rehashe undervejs,
    // hvilket er en dyr operation.

    // TreeSet vokser mere jævnt uden resizing, hvilket kan gøre den hurtigere
    // i denne specifikke måling.

    // Generelt gælder:
    // HashSet er hurtigst, men uden sortering.
    // TreeSet er langsommere, men holder altid elementerne sorteret.


    public static void main(String[] args) {
        final int SIZE = 200_000;

        HashSet<Product> hashSet = new HashSet<>();
        TreeSet<Product> treeSet = new TreeSet<>();


        // --- ADD ---
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            hashSet.add(new Product(i, "P" + i));
        }
        long hashAdd = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            treeSet.add(new Product(i, "P" + i));
        }
        long treeAdd = System.nanoTime() - start;

        // --- CONTAINS ---
        Product search = new Product(150_000, "P150000");

        start = System.nanoTime();
        hashSet.contains(search);
        long hashContains = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.contains(search);
        long treeContains = System.nanoTime() - start;

        // --- REMOVE ---
        start = System.nanoTime();
        hashSet.remove(search);
        long hashRemove = System.nanoTime() - start;

        start = System.nanoTime();
        treeSet.remove(search);
        long treeRemove = System.nanoTime() - start;

        // --- RESULTS ---
        System.out.printf("%-15s %15s %15s%n", "Operation", "HashSet", "TreeSet");
        System.out.println("-".repeat(50));
        System.out.printf("%-15s %12d ns %12d ns%n", "add", hashAdd, treeAdd);
        System.out.printf("%-15s %12d ns %12d ns%n", "contains", hashContains, treeContains);
        System.out.printf("%-15s %12d ns %12d ns%n", "remove", hashRemove, treeRemove);
    }
}