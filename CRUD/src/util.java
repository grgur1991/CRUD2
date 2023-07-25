import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.text.SimpleDateFormat;

public class util{
    public static Scanner scanner = new Scanner(System.in);

    public static boolean readGender(String message) {
        String statement;

        while (true) {
            System.out.println(message);
            statement = scanner.nextLine();
            if (statement.trim().equalsIgnoreCase("m")) {
                return true;
            }
            if (statement.trim().equalsIgnoreCase("f")) {
                return false;
            }
            System.out.println("You can only enter M for male or F for female.");
        }
    }

    public static int readInt(String message, String error, int min, int max) {
        int number;
        while (true) {
            System.out.println(message);
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number < min || number > max) {
                    System.out.println("Number must be between " + min + " and " + max + ".");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(error);
            }
        }
        return number;
    }

    public static boolean readYesOrNo(String message, String error) {
        String statement;

        while (true) {
            System.out.println(message);
            statement = scanner.nextLine();
            if (statement.trim().equalsIgnoreCase("yes")) {
                return true;
            }
            if (statement.trim().equalsIgnoreCase("no")) {
                return false;
            }
            System.out.println(error);
        }
    }

    public static String readString(String message, String error) {
        String string;
        while (true) {
            System.out.println(message);
            string = scanner.nextLine();
            if (string.trim().isEmpty()) {
                System.out.println(error);
                continue;
            }
            break;
        }
        return string;
    }

    public static Date readDate(String message, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        while (true) {
            System.out.println(message);
            try {
                return sdf.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date format. Example input: " + sdf.format(new Date()));
            }
        }
    }

    public static void printMessage(String message) {
        System.out.println("Message: " + message);
    }
}

class Input {
    HashMap<String, String> knowledge = new HashMap<String, String>();

    public Input() {
        // First greetings
        knowledge.put("hi", "Hi, how can I help you?");
        knowledge.put("hello", "Hi, how can I help you?");
        knowledge.put("bye", "Goodbye!");

        // Add more knowledge entries as needed...
    }

    public void answerBot(String question) {
        Set<String> keys = knowledge.keySet();
        for (String key : keys) {
            String lowerKey = key.toLowerCase();
            String lowerQuestion = question.toLowerCase();
            if (lowerKey.contains(lowerQuestion)) {
                util.printMessage("Bot: " + knowledge.get(key));
                return;
            }
        }
    }
}