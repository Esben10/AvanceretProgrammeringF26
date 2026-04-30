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
        testLinkedListExercises();
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

    // ==================== EXERCISE 2: Reverse Linked List ====================
    
    /**
     * Exercise 2: Reverser listen
     * Reverserer en linked list ved at få hver node til at pege på sin foregående node
     * 
     * Pseudokode:
     * 1. previous = null
     * 2. current = head
     * 3. While current != null:
     *    a. Save next node (current.next)
     *    b. Make current point to previous (reverse the link)
     *    c. Move previous forward to current
     *    d. Move current forward to the saved next
     * 4. Return previous (new head)
     */
    public static algorithms.reversedlinkedlist.Node reverseList(algorithms.reversedlinkedlist.Node head) {
        algorithms.reversedlinkedlist.Node previous = null;
        algorithms.reversedlinkedlist.Node current = head;
        
        while (current != null) {
            // Save the next node before we change the link
            algorithms.reversedlinkedlist.Node next = current.next;
            
            // Reverse the link - point current to the previous node
            current.next = previous;
            
            // Move forward: previous becomes current
            previous = current;
            
            // Move current to the next node
            current = next;
        }
        
        // previous is now the new head of the reversed list
        return previous;
    }

    // ==================== EXERCISE 4: Cycle Detector ====================
    
    /**
     * Exercise 4: Lav en cycle detector
     * Detekterer om en linked list har en cyklus ved hjælp af Floyd's cycle detection algorithm
     * (Tortoise and Hare)
     * 
     * Algoritme:
     * 1. Brug to pointere: slow (bevæger sig 1 skridt) og fast (bevæger sig 2 skridt)
     * 2. Hvis de mødes, er der en cyklus
     * 3. Hvis fast når enden (null), er der ingen cyklus
     */
    public static boolean hasCycle(algorithms.reversedlinkedlist.Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        algorithms.reversedlinkedlist.Node slow = head;
        algorithms.reversedlinkedlist.Node fast = head;
        
        // Bevæg pointerne mens fast ikke når enden
        while (fast != null && fast.next != null) {
            // slow bevæger sig 1 skridt
            slow = slow.next;
            
            // fast bevæger sig 2 skridt
            fast = fast.next.next;
            
            // Tjek om de mødes - hvis ja, er der en cyklus
            if (slow == fast) {
                return true;
            }
        }
        
        // fast nåede enden uden at møde slow, så ingen cyklus
        return false;
    }

    // ==================== TEST METHOD ====================
    
    /**
     * Test method for exercises 1-4
     * Kald denne metode fra main() for at teste reversering og cycle detection
     */
    public static void testLinkedListExercises() {
        System.out.println("======== EXERCISE 1 & 2: Reversed Linked List ========\n");
        
        // Opret en normal liste: 1 -> 5 -> 7 -> 12 -> 17 -> null
        algorithms.reversedlinkedlist.Node list = 
            algorithms.reversedlinkedlist.ListFactory.buildList(1, 5, 7, 12, 17);
        
        System.out.println("Original liste:");
        printReversedLinkedList(list);
        
        // Reverser listen
        algorithms.reversedlinkedlist.Node reversed = reverseList(list);
        
        System.out.println("\nReversearet liste:");
        printReversedLinkedList(reversed);
        
        System.out.println("\n======== EXERCISE 3 & 4: Circular Linked List ========\n");
        
        // Test normal liste (uden cyklus)
        algorithms.circularlinkedlist.Node normalList = 
            algorithms.circularlinkedlist.ListFactory.buildList(1, 2, 3, 4, 5);
        
        System.out.println("Normal liste (uden cyklus): " + normalList);
        System.out.println("Har cyklus? " + hasCycleCircular(normalList) + " (forventet: false)");
        
        // Test cirkulær liste (med cyklus)
        algorithms.circularlinkedlist.Node circularList = 
            algorithms.circularlinkedlist.ListFactory.buildListWithCycle();
        
        System.out.println("\nCirkulær liste (1->2->3->4->5->2->...)");
        // Vi printer ikke hele den cirkulære liste da den ville være uendelig!
        System.out.println("Har cyklus? " + hasCycleCircular(circularList) + " (forventet: true)");
        
        System.out.println("\n======== BONUS: Floyd's Array Example ========\n");
        System.out.println("Array: {2, 0, 1}");
        System.out.println("Har cyklus? " + algorithms.floydexample.TraversingArrays.hasCycle(new int[]{2, 0, 1}));
        System.out.println("Forklaring: Hvis vi følger indekserne som 'next pointers':");
        System.out.println("  Start: index 0 -> arr[0]=2 -> arr[2]=1 -> arr[1]=0 -> (tilbage til 0)");
        System.out.println("  Dette danner en cyklus: 0->2->1->0->..., så der returneres true");
    }
    
    /**
     * Hjælpemetode til at printe en reversedlinkedlist.Node liste
     */
    private static void printReversedLinkedList(algorithms.reversedlinkedlist.Node node) {
        StringBuilder sb = new StringBuilder();
        algorithms.reversedlinkedlist.Node current = node;
        while (current != null) {
            sb.append(current.value).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        System.out.println(sb.toString());
    }
    
    /**
     * Hjælpemetode til cycle detection på circularlinkedlist.Node
     */
    private static boolean hasCycleCircular(algorithms.circularlinkedlist.Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        algorithms.circularlinkedlist.Node slow = head;
        algorithms.circularlinkedlist.Node fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }

}
