package searchandsort.entities;

import java.util.Objects;

public class Student implements Comparable<Student> {

    private String name;
    private int id;


    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    public int compareName(){
        return 0;
    }

    @Override
    public int compareTo(Student other){
        if (this.equals(other)) return 0;
        else if (this.getId() > other.getId()) return 1;
        else return -1;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", id=" + id +
                " name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}