import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntTest {

    ReverseInt reverseInt = new ReverseInt();

    @Test
    @DisplayName("ReverseInt handles 0 as an input")
    void reverse_1() {
        assertThat(reverseInt.reverse(0), is(0));
    }

    @Test
    @DisplayName("ReverseInt flips a positive number")
    void reverse_2() {
        assertThat(reverseInt.reverse(5), is(5));
        assertThat(reverseInt.reverse(15), is(51));
        assertThat(reverseInt.reverse(90), is(9));
        assertThat(reverseInt.reverse(2359), is(9532));
    }


    @Test
    @DisplayName("ReverseInt flips a negative number")
    void reverse_3() {
        assertThat(reverseInt.reverse(-5), is(-5));
        assertThat(reverseInt.reverse(-15), is(-51));
        assertThat(reverseInt.reverse(-90), is(-9));
        assertThat(reverseInt.reverse(-2359), is(-9532));
    }
}