import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CapitalizeTest {

    Capitalize capitalize = new Capitalize();

    @Test
    @DisplayName("capitalizes the first letter of every word in a sentence")
    void capitalize_1() {
        assertThat(capitalize.capitalize("hi there, how is it going?"), is(equalTo("Hi There, How Is It Going?")));
    }

    @Test
    @DisplayName("capitalizes the first letter")
    void capitalize_2() {
        assertThat(capitalize.capitalize("i love breakfast at bill miller bbq"), is(equalTo("I Love Breakfast At Bill Miller Bbq")));
    }
}