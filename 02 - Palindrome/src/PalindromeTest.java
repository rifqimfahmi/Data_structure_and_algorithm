
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    Palindrome palindrome = new Palindrome();

    @Test
    @DisplayName("\"aba\" is a palindrome")
    void palindrome_1() {
        assertThat(palindrome.check("aba"), is(true));
    }

    @Test
    @DisplayName(" aba\" is not a palindrome")
    void palindrome_2() {
        assertThat(palindrome.check(" aba"), is(false));
    }

    @Test
    @DisplayName("aba \" is not a palindrome")
    void palindrome_3() {
        assertThat(palindrome.check("aba "), is(false));
    }

    @Test
    @DisplayName("\"greetings\" is not a palindrome")
    void palindrome_4() {
        assertThat(palindrome.check("greetings"), is(false));
    }

    @Test
    @DisplayName("\"1000000001\" a palindrome")
    void palindrome_5() {
        assertThat(palindrome.check("1000000001"), is(true));
    }

    @Test
    @DisplayName("\"Fish hsif\" is not a palindrome")
    void palindrome_6() {
        assertThat(palindrome.check("Fish hsif"), is(false));
    }

    @Test
    @DisplayName("\"pennep\" a palindrome")
    void palindrome_7() {
        assertThat(palindrome.check("pennep"), is(true));
    }
}