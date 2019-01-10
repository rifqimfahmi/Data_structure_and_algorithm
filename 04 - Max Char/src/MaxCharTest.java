import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class MaxCharTest {

    MaxChar maxChar = new MaxChar();

    @Test
    @DisplayName("Finds the most frequently used char")
    void find_1() {
        assertThat(maxChar.find("a"), is(equalTo('a')));
        assertThat(maxChar.find("abcdefghijklmnaaaaa"), is(equalTo('a')));
    }

    @Test
    @DisplayName("Works with numbers in the string")
    void find_2() {
        assertThat(maxChar.find("ab1c1d1e1f1g1"), is(equalTo('1')));
    }
}