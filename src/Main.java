import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"no1","dn"));
        students.add(new Student(2,"no2","sg"));
        students.add(new Student(3,"no3","hn"));
        writeDataToFile("Student.txt",students);
        List<Student> readToFile = readDataToFile("Student.txt");
        for (Student student: readToFile) {
            System.out.println(student);
        }
    }
    public static void writeDataToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<Student> readDataToFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            ois.close();
            fis.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}