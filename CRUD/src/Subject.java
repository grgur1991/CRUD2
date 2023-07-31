import java.util.ArrayList;
import java.util.List;
public class Subject {
    private String subjectName;
    private List<Teacher> teachers;
    private List<Student> students;

    public Subject(String subjectName) {
        this.subjectName = subjectName;
        this.teachers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}