package searchandsort;

import searchandsort.entities.Student;
import searchandsort.util.Factory;

import java.util.*;

public class Main {

    public static void main(String[] args) {
       //  testComplexity();
       // testLinearAndBinarySearch();
       // testBubble(10, true, true);
       //  testMerge(10, true, true);
       // testQuick(50000, true, true);
        testBubbleInt();
        testMergeInt();
        testQuickInt();
    }

    private static void testComplexity() {
        int n = 10000; // justér for at demonstrere tydeligt

        // O(1)
        long start = System.currentTimeMillis();
        BigOExamples.constantTime(n);
        long stop = System.currentTimeMillis();
        System.out.println("Time for O(1): " + (stop - start) + " ms\n");

        // O(log n)
        start = System.currentTimeMillis();
        BigOExamples.logTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(log n): " + (stop - start) + " ms\n");

        // O(n)
        start = System.currentTimeMillis();
        BigOExamples.linearTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n): " + (stop - start) + " ms\n");

        // O(n²) - pas på med at vælge et for stort n!
       /* n = 2000; // mindre n for kvadratisk!
        start = System.currentTimeMillis();
        BigOExamples.quadraticTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n²): " + (stop - start) + " ms\n");*/
    }

    private static void testLinearAndBinarySearch() {
        List<Student> students = new ArrayList<>();
        Factory.fillWithStudents(students, 100000);

        int targetId = 99999; // sidst i listen, så forskellen er tydelig!

        // Lineær søgning
        long start = System.currentTimeMillis();
        Student studentLinear = SearchExamples.linearSearch(students, targetId);
        long stop = System.currentTimeMillis();
        System.out.println("Lineær søgning fandt: " + studentLinear);
        System.out.println("Tid: " + (stop - start) + " ms");

        // Sorter listen efter ID (nødvendigt for binær søgning)
        // Hvad sorteres de studerende efter? Hvordan finder vi ud af det?
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        // Binær søgning
        start = System.currentTimeMillis();
        Student studentBinary = SearchExamples.binarySearch(students, targetId);
        stop = System.currentTimeMillis();
        System.out.println("Binær søgning fandt: " + studentBinary);
        System.out.println("Tid: " + (stop - start) + " ms");
    }

    private static void testBubble(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Bubble Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.bubbleSort(list);
        long stop = System.currentTimeMillis();
        if (print) printList("Bubble Sort - efter", list);
        if (time) System.out.println("Bubble Sort - tid: " + (stop - start) + " ms");
    }

    private static void testHeap(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Heap Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.heapSort(list);
        long stop = System.currentTimeMillis();
        if (print) printList("Heap Sort - efter", list);
        if (time) System.out.println("Heap Sort - tid: " + (stop - start) + " ms");
    }

    private static void testQuick(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        //Collections.shuffle(list);
        if (print) printList("Quick Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.quickSort(list, 0, list.size() - 1);
        long stop = System.currentTimeMillis();
        if (print) printList("Quick Sort - efter", list);
        if (time) System.out.println("Quick Sort - tid: " + (stop - start) + " ms");
    }

    private static void testMerge(int size, boolean time, boolean print) {
        List<Student> original = new ArrayList<>();
        Factory.fillWithStudents(original, size);
        Collections.shuffle(original);
        Student[] mergearray = original.toArray(new Student[0]);
        if (print) printArray("Merge Sort - før", mergearray);
        long start = System.currentTimeMillis();
        SortExamples.mergeSort(mergearray);
        long stop = System.currentTimeMillis();
        if (print) printArray("Merge Sort - efter", mergearray);
        if (time) System.out.println("Merge Sort - tid: " + (stop - start) + " ms");
    }

    // Hjælpemetoder til udskrift
    private static void printList(String label, List<Student> list) {
        System.out.println(label + ": ");
        for(Student s:list){
            System.out.println(s);
        }
    }

    private static void printArray(String label, Student[] arr) {
        System.out.println(label + ": ");
        for(Student s:arr){
            System.out.println(s);
        }
    }

    private static void testBubbleInt() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Bubble Sort int[] - før:  " + Arrays.toString(arr));
        SortExamples.bubbleSort(arr);
        System.out.println("Bubble Sort int[] - efter: " + Arrays.toString(arr));
    }

    private static void testMergeInt() {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Merge Sort int[]  - før:  " + Arrays.toString(arr));
        SortExamples.mergeSort(arr);
        System.out.println("Merge Sort int[]  - efter: " + Arrays.toString(arr));
    }

    private static void testQuickInt() {
        int[] arr = {10, 7, 8, 9, 1, 5};
        System.out.println("Quick Sort int[]  - før:  " + Arrays.toString(arr));
        SortExamples.quickSort(arr, 0, arr.length - 1);
        System.out.println("Quick Sort int[]  - efter: " + Arrays.toString(arr));
    }

    private static Student[] createCardArray(){
        Student[] arr = new Student[6];
        arr[0] =  new Student("Tre", 3);
        arr[1] = new Student("Ni", 9);
        arr[2] = new Student("Syv", 7);
        arr[3] = new Student("10", 10);
        arr[4] = new Student("Dronning", 12);
        arr[5] = new Student("Fire", 4);
        return arr;
    }

}
