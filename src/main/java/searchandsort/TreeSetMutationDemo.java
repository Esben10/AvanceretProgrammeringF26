package searchandsort;

import java.sql.SQLOutput;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetMutationDemo {

    static class Student implements Comparable<Student> {
        private String name;
        private int id;

        public Student(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int compareTo(Student other) {
            return Integer.compare(this.id, other.id);
        }

        @Override
        public String toString() {
            return name + " (id=" + id + ")";
        }
    }

    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();

        Student alice = new Student("Alice", 1);
        Student bob = new Student("Bob", 2);
        students.add(alice);
        students.add(bob);

        System.out.println("Før ændring:");
        students.forEach(System.out::println);


        Student charlie = new Student("Charlie", 3);
        students.add(charlie);

        System.out.println("\nEfter tilføjelse af Charlie (id=3):");
        students.forEach(System.out::println);

        boolean b =students.add(new Student("Dora", 3));
      //  students.forEach(System.out::println);
        System.out.println("Dora blev sat ind? " + b);

        // Ændr id på Alice, så det bliver "forkert"
        alice.setId(3);

        System.out.println("\nEfter ændring (Alice har nu id=3):");
        students.forEach(System.out::println);

        System.out.println("Findes Alice? " + students.contains(alice));
        students.remove(alice);
        students.forEach(System.out::println);

        System.out.println("Findes Alice? " + students.contains(alice));


    }

}
