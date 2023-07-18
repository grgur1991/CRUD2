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

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "Subject [id=" + id + ", name=" + name + "]";
    }
}
