
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class MainTest {

    private Anagram anagram = new Anagram();

    @Test
    @DisplayName("\"hello\" is an check of \"llohe\"")
    void anagram_1() {
        assertThat(anagram.check("hello", "llohe"), is(equalTo(true)));
    }

    @Test
    @DisplayName("\"Whoa! Hi!\" is an check of \"Hi! Whoa!\"")
    void anagram_2() {
        assertThat(anagram.check("Whoa! Hi!", "Hi! Whoa!"), is(equalTo(true)));
    }

    @Test
    @DisplayName("\"One One\" is not an check of \"Two two two\"")
    void anagram_3() {
        assertThat(anagram.check("One One", "Two two two"), is(equalTo(false)));
    }

    @Test
    @DisplayName("\"One one\" is not an check of \"One one c\"")
    void anagram_4() {
        assertThat(anagram.check("One one", "One one c"), is(equalTo(false)));
    }


    @Test
    @DisplayName("A tree, a life, a bench\" is not an anagram of \"A tree, a fence, a yard")
    void anagram_5() {
        assertThat(anagram.check("A tree, a life, a bench", "A tree, a fence, a yard"), is(equalTo(false)));
    }
}