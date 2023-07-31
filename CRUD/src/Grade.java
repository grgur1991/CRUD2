public class Grade {
    private Student student;
    private Course course;
    private String exam;
    private int grade; // Add a field to store the grade value

    public Grade(Student student, Course course, String exam, int grade) {
        this.student = student;
        this.course = course;
        this.exam = exam;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public String getExam() {
        return exam;
    }

    public int getGrade() {
        return grade; // Provide a getter method to access the grade value
    }
}
