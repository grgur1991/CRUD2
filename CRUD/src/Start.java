import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    private List<Subject> subjects;
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private List<Grade> grades;
    private Scanner scanner;

    public static void main(String[] args) {
        Start main = new Start();
        main.initializeData();
        main.displayMenu();
    }

    public Start() {
        subjects = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
        grades = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private void initializeData() {
        // For demonstration purposes, let's add some initial data
        // Students
        Student student1 = new Student("Alice", 16, false);
        Student student2 = new Student("Bob", 15, true);
        students.add(student1);
        students.add(student2);

        // Teachers
        Teacher teacher1 = new Teacher("John Doe", 35, true);
        Teacher teacher2 = new Teacher("Jane Smith", 40, false);
        teachers.add(teacher1);
        teachers.add(teacher2);

        // Subjects
        Subject math = new Subject("Math");
        math.addTeacher(teacher1);
        math.addStudent(student1);
        math.addStudent(student2);
        subjects.add(math);

        Subject history = new Subject("History");
        history.addTeacher(teacher2);
        history.addStudent(student1);
        history.addStudent(student2);
        subjects.add(history);

        // Courses (new data for demonstration)
        Course mathCourse = new Course("MATH101", "Mathematics 101", 3);
        Course historyCourse = new Course("HIST101", "History 101", 3);
        courses.add(mathCourse);
        courses.add(historyCourse);

        // Grades (new data for demonstration)
        Grade grade1 = new Grade(student1, mathCourse, "Midterm Exam", 90);
        Grade grade2 = new Grade(student1, historyCourse, "Final Exam", 85);
        grades.add(grade1);
        grades.add(grade2);
    }

    private void displayMenu() {
        System.out.println("Welcome to the Classroom");
        int option;
        do {
            System.out.println("Menu");
            System.out.println("1. View Subjects");
            System.out.println("2. Add Subject");
            System.out.println("3. Update Subject");
            System.out.println("4. Delete Subject");
            System.out.println("5. View Courses");
            System.out.println("6. Add Course");
            System.out.println("7. View Grades");
            System.out.println("8. Add Grade");
            System.out.println("9. View Saved Data");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        viewSubjects();
                        break;
                    case 2:
                        addSubject();
                        break;
                    case 3:
                        displaySubjectsForUpdate();
                        break;
                    case 4:
                        displaySubjectsForDeletion();
                        break;
                    case 5:
                        viewCourses();
                        break;
                    case 6:
                        addCourse();
                        break;
                    case 7:
                        viewGrades();
                        break;
                    case 8:
                        addGrade();
                        break;
                    case 9:
                        viewSavedData();
                        break;
                    case 10:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1 to 10).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1 to 10).");
                scanner.nextLine(); // Clear the invalid input
                option = 0; // Reset the option to re-prompt the user
            }

            System.out.println();
        } while (option != 10);
    }

    private void viewSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectName());
        }

        String subjectName = Util.readString("Enter the subject name to view details (or type 'back' to return to the main menu): ", "Subject name cannot be empty.");

        if (subjectName.equalsIgnoreCase("back")) {
            return;
        }

        boolean found = false;
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equalsIgnoreCase(subjectName)) {
                System.out.println("Teachers for " + subjectName + ":");
                for (Teacher teacher : subject.getTeachers()) {
                    System.out.println("  - " + teacher.getName() + " (Age: " + teacher.getAge() + ", Gender: " + (teacher.isMale() ? "Male" : "Female") + ")");
                }

                System.out.println("Students attending " + subjectName + ":");
                for (Student student : subject.getStudents()) {
                    System.out.println("  - " + student.getName() + " (Age: " + student.getAge() + ", Gender: " + (student.isMale() ? "Male" : "Female") + ")");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Subject not found.");
        }
    }

    private void addSubject() {
        System.out.print("Enter the subject name: ");
        String subjectName = scanner.nextLine();

        Subject newSubject = new Subject(subjectName);

        boolean addTeacher = Util.readYesOrNo("Do you want to add a teacher for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");

        while (addTeacher) {
            String teacherName = Util.readString("Enter the teacher's name: ", "Teacher's name cannot be empty.");
            int teacherAge = Util.readInt("Enter the teacher's age: ", "Invalid input. Please enter a valid age.", 18, 100);
            boolean isMale = Util.readGender("Enter the teacher's gender (M/F): ");
            newSubject.addTeacher(new Teacher(teacherName, teacherAge, isMale));

            addTeacher = Util.readYesOrNo("Do you want to add another teacher for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");
        }

        boolean addStudents = Util.readYesOrNo("Do you want to add students for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");

        while (addStudents) {
            String studentName = Util.readString("Enter the student's name: ", "Student's name cannot be empty.");
            int studentAge = Util.readInt("Enter the student's age: ", "Invalid input. Please enter a valid age.", 5, 18);

            boolean isMale = Util.readGender("Enter the student's gender (M/F): ");
            newSubject.addStudent(new Student(studentName, studentAge, isMale));

            addStudents = Util.readYesOrNo("Do you want to add another student for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");
        }

        subjects.add(newSubject);
        System.out.println("Subject added successfully!");
    }

    private void displaySubjectsForUpdate() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.println("Available Subjects for Update:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getSubjectName());
        }

        int subjectIndex = Util.readInt("Enter the number of the subject you want to update (or 0 to cancel): ", "Invalid input. Please enter a valid number.", 0, subjects.size());
        if (subjectIndex == 0) {
            System.out.println("Update operation cancelled.");
        } else {
            String subjectNameToUpdate = subjects.get(subjectIndex - 1).getSubjectName();
            updateSubject(subjectNameToUpdate);
        }
    }

    private void updateSubject(String subjectNameToUpdate) {
        Subject subjectToUpdate = findSubjectByName(subjectNameToUpdate);
        if (subjectToUpdate == null) {
            System.out.println("Subject not found.");
            return;
        }

        System.out.println("Update Subject: " + subjectNameToUpdate);
        boolean updateTeachers = Util.readYesOrNo("Do you want to update teachers for " + subjectNameToUpdate + "? (yes/no)", "Please enter 'yes' or 'no'.");
        if (updateTeachers) {


            boolean addTeacher = true;
            while (addTeacher) {
                String teacherName = Util.readString("Enter the teacher's name: ", "Teacher's name cannot be empty.");
                int teacherAge = Util.readInt("Enter the teacher's age: ", "Invalid input. Please enter a valid age.", 18, 100);
                boolean isMale = Util.readGender("Enter the teacher's gender (M/F): ");
                subjectToUpdate.addTeacher(new Teacher(teacherName, teacherAge, isMale));

                addTeacher = Util.readYesOrNo("Do you want to add another teacher for " + subjectNameToUpdate + "? (yes/no)", "Please enter 'yes' or 'no'.");
            }
        }

        boolean updateStudents = Util.readYesOrNo("Do you want to update students for " + subjectNameToUpdate + "? (yes/no)", "Please enter 'yes' or 'no'.");
        if (updateStudents) {


            boolean addStudents = true;
            while (addStudents) {
                String studentName = Util.readString("Enter the student's name: ", "Student's name cannot be empty.");
                int studentAge = Util.readInt("Enter the student's age: ", "Invalid input. Please enter a valid age.", 5, 18);
                boolean isMale = Util.readGender("Enter the student's gender (M/F): ");
                subjectToUpdate.addStudent(new Student(studentName, studentAge, isMale));

                addStudents = Util.readYesOrNo("Do you want to add another student for " + subjectNameToUpdate + "? (yes/no)", "Please enter 'yes' or 'no'.");
            }
        }

        System.out.println("Subject " + subjectNameToUpdate + " updated successfully!");
    }

    private Subject findSubjectByName(String name) {
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equalsIgnoreCase(name)) {
                return subject;
            }
        }
        return null;
    }

    private void displaySubjectsForDeletion() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.println("Available Subjects for Deletion:");
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getSubjectName());
        }

        int subjectIndex = Util.readInt("Enter the number of the subject you want to delete (or 0 to cancel): ", "Invalid input. Please enter a valid number.", 0, subjects.size());
        if (subjectIndex == 0) {
            System.out.println("Delete operation cancelled.");
        } else {
            String subjectNameToDelete = subjects.get(subjectIndex - 1).getSubjectName();
            deleteSubject(subjectNameToDelete);
        }
    }

    private void deleteSubject(String subjectNameToDelete) {
        Subject subjectToDelete = findSubjectByName(subjectNameToDelete);
        if (subjectToDelete == null) {
            System.out.println("Subject not found.");
            return;
        }

        subjects.remove(subjectToDelete);
        System.out.println("Subject " + subjectNameToDelete + " deleted successfully!");
    }


    private void viewSavedData() {
        // Display the saved data
        System.out.println("Saved Data:");

        // Display subjects
        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectName());
        }

        // Display courses
        System.out.println("\nCourses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Course Title: " + course.getCourseTitle());
            System.out.println("Credits: " + course.getCredits());
            System.out.println();
        }

        // Display grades
        System.out.println("\nGrades:");
        for (Grade grade : grades) {
            System.out.println("Student: " + grade.getStudent().getName());
            System.out.println("Course: " + grade.getCourse().getCourseCode());
            System.out.println("Exam: " + grade.getExam());
            System.out.println("Grade: " + grade.getGrade());
            System.out.println();
        }
    }
    private void viewCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }

        System.out.println("Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseCode() + " - " + course.getCourseTitle());
        }

        String courseCode = Util.readString("Enter the course code to view details (or type 'back' to return to the main menu): ", "Course code cannot be empty.");

        if (courseCode.equalsIgnoreCase("back")) {
            return;
        }

        boolean found = false;
        for (Course course : courses) {
            if (course.getCourseCode().equalsIgnoreCase(courseCode)) {
                System.out.println("Course Details for " + course.getCourseCode() + " - " + course.getCourseTitle());
                System.out.println("Credits: " + course.getCredits());
                System.out.println("Description: " + course.getDescription());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found.");
        }
    }

    private void addCourse() {
        System.out.print("Enter the course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter the course title: ");
        String courseTitle = scanner.nextLine();

        int credits = Util.readInt("Enter the course credits: ", "Invalid input. Please enter a valid integer value.", 1, 10);

        System.out.print("Enter the course description: ");
        String description = scanner.nextLine();

        Course newCourse = new Course(courseCode, courseTitle, credits );
        courses.add(newCourse);

        System.out.println("Course added successfully!");
    }

    private void viewGrades() {
        if (grades.isEmpty()) {
            System.out.println("No grades found.");
            return;
        }

        System.out.println("Grades:");

        for (Grade grade : grades) {
            System.out.println("Student: " + grade.getStudent().getName());
            System.out.println("Course: " + grade.getCourse().getCourseCode());
            System.out.println("Exam: " + grade.getExam());
            System.out.println("Grade: " + grade.getGrade());
            System.out.println();
        }
    }

    private void addGrade() {
        if (students.isEmpty()) {
            System.out.println("No students found. Cannot add grade without students.");
            return;
        }

        // Display available students for selection
        System.out.println("Available Students:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getName());
        }

        int studentIndex = Util.readInt("Enter the number of the student to add a grade (or 0 to cancel): ", "Invalid input. Please enter a valid number.", 0, students.size());
        if (studentIndex == 0) {
            System.out.println("Adding grade operation cancelled.");
            return;
        }

        Student selectedStudent = students.get(studentIndex - 1);

        // Display available courses for selection
        System.out.println("\nAvailable Courses:");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println((i + 1) + ". " + courses.get(i).getCourseCode() + " - " + courses.get(i).getCourseTitle());
        }

        int courseIndex = Util.readInt("Enter the number of the course to add a grade (or 0 to cancel): ", "Invalid input. Please enter a valid number.", 0, courses.size());
        if (courseIndex == 0) {
            System.out.println("Adding grade operation cancelled.");
            return;
        }

        Course selectedCourse = courses.get(courseIndex - 1);

        // Get the exam name and grade value
        System.out.print("Enter the exam name: ");
        String examName = scanner.nextLine();

        int gradeValue = Util.readInt("Enter the grade value: ", "Invalid input. Please enter a valid integer value.", 0, 100);

        // Create the Grade object and add it to the grades list
        Grade newGrade = new Grade(selectedStudent, selectedCourse, examName, gradeValue);
        grades.add(newGrade);

        System.out.println("Grade added successfully!");
    }
}