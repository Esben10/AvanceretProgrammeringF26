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




}
