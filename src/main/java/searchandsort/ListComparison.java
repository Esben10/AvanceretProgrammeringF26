package searchandsort;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison {

    //brugen af get i ArrayList er konstant tid fordi den ved indexet den skal finde elementet på.
    //LinkedList skal hoppe igennem alle elementer lineært så den er lidt langsommere.

    //til gengæld når man vil tilføje eller slette elementer i arraylist så skal den skifte
    //- alle elementernes index for at tilpasse
    //her er linkedlist utroligt effektiv fordi den kun skal ændre pointerne.

    //get(250000)                       6300 ns      2611200 ns
    //add(250000, 99)                  84700 ns       875600 ns
    //remove(250000)                   74600 ns       619200 ns

    //på min computer er arraylist til gengæld hurtigere til add/remove med dette eksempel nok fordi min cpu er god.

    public static void main(String[] args) {
        final int SIZE = 500_000;
        final int MID = 250_000;

        // --- Setup ---
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        // --- get(250000) ---
        long start = System.nanoTime();
        arrayList.get(MID);
        long arrayListGet = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.get(MID);
        long linkedListGet = System.nanoTime() - start;

        // --- add(250000, 99) ---
        start = System.nanoTime();
        arrayList.add(MID, 99);
        long arrayListAdd = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.add(MID, 99);
        long linkedListAdd = System.nanoTime() - start;

        // --- remove(250000) ---
        start = System.nanoTime();
        arrayList.remove(MID);
        long arrayListRemove = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.remove(MID);
        long linkedListRemove = System.nanoTime() - start;

        // --- Results ---
        System.out.printf("%-25s %15s %15s%n", "Operation", "ArrayList", "LinkedList");
        System.out.println("-".repeat(55));
        System.out.printf("%-25s %12d ns %12d ns%n", "get(250000)",    arrayListGet,    linkedListGet);
        System.out.printf("%-25s %12d ns %12d ns%n", "add(250000, 99)", arrayListAdd,   linkedListAdd);
        System.out.printf("%-25s %12d ns %12d ns%n", "remove(250000)", arrayListRemove, linkedListRemove);
    }
}