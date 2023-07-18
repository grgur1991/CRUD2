import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Teacher> teachers = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();

        //Create

        Teacher teacher1 = new Teacher(1,"John");
        Teacher teacher2 = new Teacher(2, "Marc");
        teachers.add(teacher1);
        teachers.add(teacher2);

        Student student1 = new Student(1,"Rocco");
        Student student2 = new Student(2,"Jenny");
        students.add(student1);
        students.add(student2);

        Subject subject1 = new  Subject(1,"Math");
        Subject subject2 = new Subject(2,"Music");
        subjects.add(subject1);
        subjects.add(subject2);



        //Read
        System.out.println(teachers);
        System.out.println(students);
        System.out.println(subjects);



        //Update
        teacher1.setName("Ann");
        student1.setName("Mike");
        subject1.setName("History");



        //Delete

        teachers.remove(teachers);
        System.out.println(teachers + " was removed");

        students.remove(students);
        System.out.println(students + " was removed");

        subjects.remove(subjects);
        System.out.println(subjects + " was removed");




        }
    }
