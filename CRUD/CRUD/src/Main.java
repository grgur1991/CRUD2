import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();

        // Create
        Teacher teacher1 = new Teacher(1, "John");
        Teacher teacher2 = new Teacher(2, "Marc");
        teachers.add(teacher1);
        teachers.add(teacher2);

        Student student1 = new Student(1, "Rocco");
        Student student2 = new Student(2, "Jenny");
        students.add(student1);
        students.add(student2);

        Subject subject1 = new Subject(1, "Math");
        Subject subject2 = new Subject(2, "Music");
        subjects.add(subject1);
        subjects.add(subject2);

        // Read
        System.out.println("Teachers: " + teachers);
        System.out.println("Students: " + students);
        System.out.println("Subjects: " + subjects);

        // Update
        teacher1.setName("Ann");
        student1.setName("Mike");
        subject1.setName("History");

        // Delete
        teachers.remove(teacher2);
        students.remove(student2);
        subjects.remove(subject2);

        // Read after update and delete
        System.out.println("Updated Teachers: " + teachers);
        System.out.println("Updated Students: " + students);
        System.out.println("Updated Subjects: " + subjects);
    }
}