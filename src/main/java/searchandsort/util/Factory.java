package searchandsort.util;

import searchandsort.entities.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Factory {

    private static List<String> studentNames = new ArrayList<>();
    private static String studentPath = "data/Students.txt";

    static{
        readStudentNames();
    }

    private static void readStudentNames(){
        File file = new File(studentPath);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()){
                studentNames.add(scanner.next());
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file " + studentPath + " cannot be found");
        }
    }

    public static void fillWithStudents(Collection<Student> collection, int amount){
        for(int i = 0; i < amount; i++){
            Random random = new Random();
            collection.add(new Student(studentNames.get(random.nextInt(studentNames.size())), i));
        }
    }

}
