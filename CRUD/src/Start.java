import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    private List<Subject> subjects;
    private Scanner scanner;

    public static void main(String[] args) {
        Start main = new Start();
        main.initializeData();
        main.displayMenu();
    }

    public Start() {
        subjects = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private void initializeData() {
        // For demonstration purposes, let's add some initial data
        Subject math = new Subject("Math");
        math.addTeacher(new Teacher("John Doe", 35, true));
        math.addStudent(new Student("Alice", 16, false));
        math.addStudent(new Student("Bob", 15, true));

        Subject history = new Subject("History");
        history.addTeacher(new Teacher("Jane Smith", 40, false));
        history.addStudent(new Student("Charlie", 17, true));
        history.addStudent(new Student("Diana", 16, false));

        subjects.add(math);
        subjects.add(history);
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
            System.out.println("5. View Saved Data");
            System.out.println("6. Exit");
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
                        viewSavedData();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1, 2, 3, 4, 5, or 6).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1, 2, 3, 4, 5, or 6).");
                scanner.nextLine(); // Clear the invalid input
                option = 0; // Reset the option to re-prompt the user
            }

            System.out.println();
        } while (option != 6);
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
            subjectToUpdate.getTeachers().clear();

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
            subjectToUpdate.getStudents().clear();

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

    private void deleteSubject() {
        String subjectName = Util.readString("Enter the subject name you want to delete: ", "Subject name cannot be empty.");

        Subject subjectToDelete = findSubjectByName(subjectName);
        if (subjectToDelete == null) {
            System.out.println("Subject not found.");
            return;
        }

        subjects.remove(subjectToDelete);
        System.out.println("Subject " + subjectName + " deleted successfully!");
    }

    private void addSubject() {
        System.out.print("Enter the subject name: ");
        String subjectName = scanner.nextLine();

        Subject newSubject = new Subject(subjectName);

        boolean addTeacher = Util.readYesOrNo("Do you want to add a teacher for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");

        if (addTeacher) {
            String teacherName = Util.readString("Enter the teacher's name: ", "Teacher's name cannot be empty.");
            int teacherAge = Util.readInt("Enter the teacher's age: ", "Invalid input. Please enter a valid age.", 18, 100);
            boolean isMale = Util.readGender("Enter the teacher's gender (M/F): ");
            newSubject.addTeacher(new Teacher(teacherName, teacherAge, isMale));
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
        System.out.println("Subject " + subjectName + " added successfully!");
    }

    private void viewSavedData() {
        System.out.println("Saved Data:");
        for (Subject subject : subjects) {
            System.out.println("Subject: " + subject.getSubjectName());
            System.out.println("Teachers:");
            for (Teacher teacher : subject.getTeachers()) {
                System.out.println("  - " + teacher.getName() + " (Age: " + teacher.getAge() + ", Gender: " + (teacher.isMale() ? "Male" : "Female") + ")");
            }

            System.out.println("Students:");
            for (Student student : subject.getStudents()) {
                System.out.println("  - " + student.getName() + " (Age: " + student.getAge() + ", Gender: " + (student.isMale() ? "Male" : "Female") + ")");
            }
            System.out.println();
        }
    }
}
