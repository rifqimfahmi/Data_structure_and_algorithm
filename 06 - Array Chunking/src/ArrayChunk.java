import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayChunk {
    // Time complexity O(n) - linear
    public int[][] chunk(int[] ints, int size) {
        List<int[]> res = new ArrayList<>();
        int startIndex = 0;
        int endIndex = size;

        while (startIndex < ints.length) {
            if (endIndex > ints.length) {
                endIndex = ints.length;
            }
            res.add(Arrays.copyOfRange(ints, startIndex, endIndex));
            startIndex = endIndex;
            endIndex += size;
        }

        return res.toArray(new int[][]{});
    }
}
