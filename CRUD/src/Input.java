import java.util.HashMap;
import java.util.Set;

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
        Util.printMessage("Bot: " + knowledge.get(key));
        return;
        }

        }

    }

}