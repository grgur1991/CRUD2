public class Course {
    private String courseCode;
    private String courseTitle;
    private int credits;

    public Course(String courseCode, String courseTitle, int credits) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getDescription() {
        return "Course Code: " + courseCode +
                "\nCourse Title: " + courseTitle +
                "\nCredits: " + credits;
    }
    public String getCourseTitle() {
        return courseTitle;
    }

    public int getCredits() {
        return credits;
    }
}