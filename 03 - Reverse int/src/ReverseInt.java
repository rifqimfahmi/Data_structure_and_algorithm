public class ReverseInt {
    public int reverse(int n) {
        int reversed = 0;
        int input = n;

        while (input != 0) {
            reversed = reversed * 10 + input % 10;
            input = input / 10;
        }

        return reversed;
    }

//    public int reverse(int n) {
//        int absN = (int) (n * Math.signum(n));
//        char[] nS = String.valueOf(absN).toCharArray();
//        StringBuilder reversed = new StringBuilder();
//
//        for (int i = nS.length - 1; i >= 0; i--) {
//            reversed.append(nS[i]);
//        }
//
//        return (int) (Integer.valueOf(reversed.toString()) * Math.signum(n));
//    }
}
