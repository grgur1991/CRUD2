import java.util.ArrayList;
import java.util.List;
public class Subject {
    private String name;
    private int id;
    private Teacher teacher;
    private List<Student> students;

    public Subject(int id, String name) {
        this.id = id;
        this.name = name;
        teacher = null;
        students = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + "]";
    }
}