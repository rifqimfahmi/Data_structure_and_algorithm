import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] rand = new int[]{4, 1, 2, 7, 5, 9};
        bubbleSort(rand);
        System.out.println(Arrays.toString(rand));

        rand = new int[]{4, 1, 2, 7, 5, 9};
        selectionSort(rand);
        System.out.println(Arrays.toString(rand));

        rand = new int[]{4, 1, 2, 7, 5, 9};
        insertionSort(rand);
        System.out.println(Arrays.toString(rand));
    }

    static void bubbleSort(int[] arr) {
        int offset = 0;
        while (offset < arr.length) {
            for (int i = arr.length - 1; i >= offset + 1; i--) {
                int curr = arr[i];
                int next = arr[i - 1];
                if (next > curr) {
                    swap(i, i - 1, arr);
                }
            }
            offset++;
        }
    }

    static void selectionSort(int[] arr) {
        int offset = 0;
        while (offset < arr.length) {
            int minVal = Integer.MAX_VALUE;
            int minPos = -1;
            for (int i = offset; i < arr.length; i++) { // search for the minimum value from range "offset" to array length - 1
                int val = arr[i];
                if (val < minVal) {
                    minVal = val;
                    minPos = i;
                }
            }
            swap(offset, minPos, arr);
            offset++;
        }
    }

    static void insertionSort(int[] arr) {
        int offset = 0;
        while (offset < arr.length - 1) {
            int nextNum = arr[offset + 1];
            for (int i = offset; i >= 0; i--) {
                int curr = arr[i];
                if (curr > nextNum) {
                    swap(offset + 1, i, arr);
                }
            }
            offset++;
        }
    }

    private static void swap(int index1, int index2, int[] arr) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }
}
