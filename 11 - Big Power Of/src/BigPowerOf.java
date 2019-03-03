import java.math.BigInteger;
import java.util.Arrays;

public class BigPowerOf {

    public static void main(String[] args) {
        System.out.println(bigPowOf(2, 100));
        System.out.println(bigPowOf2(2, 100));
    }

    // First implementation of big powers using simple math and array manipulation
    static String bigPowOf(int multiplier, int power){
        int[] res = new int[500];
        int size = 1;
        res[0] = 1;

        for (int i = 1; i <= power; i++) {
            size = multiply(res, multiplier, size);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(res[i]);
        }

        return sb.toString();
    }


    private static int multiply(int[] arr, int multiplier, int currSize) {
        int size = currSize;
        int carry = 0;

        for (int i = 0; i < size; i++) {
            int res = arr[i] * multiplier + carry;
            int rem = res % 10;
            carry = res / 10;
            arr[i] = rem;
        }

        while (carry > 0) {
            int rem = carry % 10;
            carry = carry / 10;
            arr[size] = rem;
            size++;
        }

        return size;
    }

    // Second implementation of power of using BigInteger class
    static String bigPowOf2(int multiplier, int power) {
        BigInteger bi = new BigInteger(String.valueOf(multiplier));
        return bi.pow(100).toString();
    }
}
