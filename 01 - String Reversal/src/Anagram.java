import java.util.Arrays;

public class Anagram {
    Boolean check(String stringA, String stringB) {
        char[] n1 = stringA.toLowerCase().toCharArray();
        char[] n2 = stringB.toLowerCase().toCharArray();

        if (n1.length != n2.length) {
            return false;
        }

        Arrays.sort(n1);
        Arrays.sort(n2);

        return new String(n1).equals(new String(n2));
    }
}
