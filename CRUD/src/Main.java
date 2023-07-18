public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1, "John Doe");
        Student student1 = new Student(1, "Alice");
        Student student2 = new Student(2, "Bob");
        Subject subject = new Subject(1, "Math");

        // Create operation
        teacher.setName(util.readString("Enter teacher's name: ", "Invalid input. Please enter a valid name."));
        System.out.println("Teacher: " + teacher);

        student1.setName(util.readString("Enter student's name: ", "Invalid input. Please enter a valid name."));
        System.out.println("Student 1: " + student1);

        student2.setName(util.readString("Enter another student's name: ", "Invalid input. Please enter a valid name."));
        System.out.println("Student 2: " + student2);

        subject.setName(util.readString("Enter subject's name: ", "Invalid input. Please enter a valid name."));
        System.out.println("Subject: " + subject);

        // Read operation
        System.out.println("Teacher's name: " + teacher.getName());
        System.out.println("Student 1's name: " + student1.getName());
        System.out.println("Student 2's name: " + student2.getName());
        System.out.println("Subject's name: " + subject.getName());

        // Update operation
        String updatedTeacherName = util.readString("Enter updated teacher's name: ", "Invalid input. Please enter a valid name.");
        teacher.setName(updatedTeacherName);
        System.out.println("Updated teacher: " + teacher);

        // Delete operation
        boolean deleteConfirmation = util.readYesOrNo("Do you want to delete the subject? (Yes/No): ", "Invalid answer. Please enter 'Yes' or 'No'.");
        if (deleteConfirmation) {
            subject = null;
            System.out.println("Subject deleted.");
        }
    }
}