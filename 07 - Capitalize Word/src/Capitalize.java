import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capitalize {
    public String capitalize(String in) {
        String[] words = Pattern.compile("\\s").split(in);
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(Character.toUpperCase(word.charAt(0)));
            if (word.length() > 1) {
                result.append(word.substring(1));
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}
