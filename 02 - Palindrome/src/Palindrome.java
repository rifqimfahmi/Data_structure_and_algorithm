import java.util.Arrays;

public class Palindrome {
    public Boolean check(String n1) {
        int start = 0;
        int end = n1.length() - 1;
        while (end > start) {
            if (n1.charAt(start) != n1.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

//    public Boolean check(String n1) {
//        int stopIndex = (int) Math.floor((n1.length() - 1) / 2.0);
//        for (int i = n1.length() - 1; i >= 0; i--) {
//            if (i <= stopIndex) {
//                break;
//            }
//
//            int oppositeIndex = n1.length() - 1 - i;
//            if (n1.charAt(oppositeIndex) != n1.charAt(i)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
