package searchandsort;

import searchandsort.entities.Student;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class SortExamples {

    public static void bubbleSort(List<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getId() > students.get(j + 1).getId()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }

    public static void heapSort(List<Student> students) {
        PriorityQueue<Student> heap = new PriorityQueue<>(Comparator.comparingInt(Student::getId));
        heap.addAll(students);

        students.clear();
        while (!heap.isEmpty()) {
            students.add(heap.poll());
        }
    }

    // rekursiv metode
    public static void quickSort(List<Student> students, int low, int high) {
        // base case - vi hopper ud af rekursion hvis low er >=  high
        if (low < high) {
            int pivot = partition(students, low, high);
            quickSort(students, low, pivot - 1);
            quickSort(students, pivot + 1, high);
        }
    }

    private static int partition(List<Student> students, int low, int high) {
        int pivotValue = students.get(high).getId();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (students.get(j).getId() <= pivotValue) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, high);
        return i + 1;
    }

    public static void recursiveCall(int i){
        if(i < 1)
            return;
        i--;
        System.out.println(i);
        recursiveCall(i);
    }

    public static void mergeSort(Student[] students){
        // Hvis der er 1 element tilbage kan vi ikke sortere mere
        // Dette er metoden base case
        if (students.length < 2)
            return;
        // Vi finder midten af students arrayet
        int middle = students.length / 2;
        // Vi laver to sub-arrays som hver er halvdelen af student-arrayet langt
        Student[] lefthalf = new Student[middle];
        Student[] righthalf = new Student[students.length - middle];

        // Vi kopierer første halvdel af students arrayet ind i lefthalf
        for(int i = 0; i < middle; i++){
            lefthalf[i] = students[i];
        }

        // Og anden halvdel ind i righthalf
        for(int i = middle; i < students.length; i++){
            righthalf[i - middle] = students[i];
        }

        /*
        Vi kunne erstatte forloops med
        System.arraycopy(students, 0, lefthalf, 0, middle);
        System.arraycopy(students, middle, righthalf, 0, students.length - middle);
         */

        // Vi kalder metoden rekursivt med de to arrays
        mergeSort(lefthalf);
        mergeSort(righthalf);

        // Vi merger de to sorterede halvdele
        merge(students, lefthalf, righthalf);
    }

    private static void merge(Student[] input, Student[] left, Student[] right){
        // Tre hjælpevariable der skal bruges som pointere i hver deres array
        int i = 0, l = 0, r = 0;
        // Så længe der er elementer i både venstre og højre array, som ikke er
        // kopieret til input-array, så fortsætter vi sortering
        while (l < left.length && r < right.length){
            if (left[l].getId() <= right[r].getId()){
                input[i] = left[l];
                l++;
                i++;
            } else {
                input[i] = right[r];
                r++;
                i++;
            }
        }
        // Når der ikke er flere elementer i enten left eller right, lægges de
        // resterende elementer i input
        while(l < left.length){
            input[i] = left[l];
            l++;
            i++;
        }
        while(r < right.length){
            input[i] = right[r];
            r++;
            i++;
        }
    }

    public static void mergeSortList(List<Student> students) {
        if (students.size() > 1) {
            int mid = students.size() / 2;
            List<Student> left = new ArrayList<>(students.subList(0, mid));
            List<Student> right = new ArrayList<>(students.subList(mid, students.size()));

            mergeSortList(left);
            mergeSortList(right);

            mergeList(students, left, right);
        }
    }

    private static void mergeList(List<Student> students, List<Student> left, List<Student> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getId() <= right.get(j).getId()) {
                students.set(k++, left.get(i++));
            } else {
                students.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            students.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            students.set(k++, right.get(j++));
        }
    }


  
    // int[] versioner til portfolio-opgaven
  
    // Bytter to elementer i et int-array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Bubble sort på int-array
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Ydre løkke: kører n-1 gange.
        // Efter i-te iteration er de i største elementer "boblede" til sidst og på plads.
        for (int i = 0; i < n - 1; i++) {

            // Indre løkke: sammenligner nabopar fra starten til det usorterede afsnit.
            // Vi stopper ved n-i-1 fordi de sidste i elementer allerede er sorterede.
            for (int j = 0; j < n - i - 1; j++) {

                // Hvis venstre nabo er større end højre, bytter vi de to elementer
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    // Merge sort på int-array
    public static void mergeSort(int[] arr) {
        // Basecase: et array med 0 eller 1 element er allerede sorteret, så vi returnerer
        if (arr.length < 2) return;

        int mid = arr.length / 2;

        // Opret to sub-arrays – én til hver halvdel
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // Kopier første halvdel af arr ind i left
        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        // Kopier anden halvdel af arr ind i right
        for (int i = mid; i < arr.length; i++) {
            right[i - mid] = arr[i];
        }

        // Sorter de to halvdele rekursivt (deler hver halvdel igen og igen)
        mergeSort(left);
        mergeSort(right);

        // Flet de nu sorterede halvdele sammen tilbage i det originale array
        merge(arr, left, right);
    }

    // Hjælpemetode til mergeSort: fletter to sorterede arrays ind i arr
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, l = 0, r = 0;

        // Sammenlign det mindste tilbageværende element fra hvert halvdel
        // og placer det mindste i arr – gentag til én halvdel er tom
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                arr[i++] = left[l++];
            } else {
                arr[i++] = right[r++];
            }
        }

        // Kopier eventuelle resterende elementer fra left (right er allerede tom)
        while (l < left.length) arr[i++] = left[l++];

        // Kopier eventuelle resterende elementer fra right (left er allerede tom)
        while (r < right.length) arr[i++] = right[r++];
    }

    // Quick sort på int-array
    public static void quickSort(int[] arr, int low, int high) {
        // stop rekursionen når delområdet har 0 eller 1 element
        if (low < high) {
            // Placer pivot på sin endelige sorterede plads og få dens indeks
            int pivotIndex = partition(arr, low, high);

            // Sorter alle elementer til venstre for pivot rekursivt
            quickSort(arr, low, pivotIndex - 1);

            // Sorter alle elementer til højre for pivot rekursivt
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Hjælpemetode til quickSort: placerer pivot på korrekt plads og returnerer dens indeks
    private static int partition(int[] arr, int low, int high) {
        // Vi vælger det sidste element i delområdet som pivot
        int pivotValue = arr[high];

        // i er "grænsen" – alt til venstre for i+1 er <= pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Hvis det aktuelle element er <= pivot, flyttes det til venstre side af grænsen
            if (arr[j] <= pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        // Sæt pivot på sin endelige plads (lige efter grænsen)
        swap(arr, i + 1, high);
        return i + 1;
    }

}
