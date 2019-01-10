import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class ArrayChunkTest {

    ArrayChunk arrayChunk = new ArrayChunk();

    @Test
    @DisplayName("chunk divides an array of 10 elements with chunk size 2")
    void chunk_1() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] chunked = arrayChunk.chunk(ints, 2);
        int[][] wanted = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

        assertThat(chunked, is(equalTo(wanted)));
    }

    @Test
    @DisplayName("chunk divides an array of 3 elements with chunk size 1")
    void chunk_2() {
        int[] ints = {1, 2, 3};
        int[][] chunked = arrayChunk.chunk(ints, 1);
        int[][] wanted = {{1}, {2}, {3}};

        assertThat(chunked, is(equalTo(wanted)));
    }

    @Test
    @DisplayName("chunk divides an array of 5 elements with chunk size 3")
    void chunk_3() {
        int[] ints = {1, 2, 3, 4, 5};
        int[][] chunked = arrayChunk.chunk(ints, 3);
        int[][] wanted = {{1, 2, 3}, {4, 5}};

        assertThat(chunked, is(equalTo(wanted)));
    }

    @Test
    @DisplayName("chunk divides an array of 13 elements with chunk size 5")
    void chunk_4() {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        int[][] chunked = arrayChunk.chunk(ints, 5);
        int[][] wanted = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13}};

        assertThat(chunked, is(equalTo(wanted)));
    }
}