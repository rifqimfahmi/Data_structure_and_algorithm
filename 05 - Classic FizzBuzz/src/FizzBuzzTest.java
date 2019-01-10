import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import  static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    FizzBuzz fizzBuzz = new FizzBuzz();
    PrintStream out;

    @BeforeEach
    void setup() {
        out = mock(PrintStream.class);
        System.setOut(out);
    }

    @Test
    @DisplayName("Calling fizzbuzz with `5` prints out 5 statements")
    void print_1() {
        fizzBuzz.print(5);

        verify(out, times(5)).println(anyString());
    }

    @Test
    @DisplayName("Calling fizzbuzz with 15 prints out the correct values")
    void print_2() {
        fizzBuzz.print(15);

        InOrder inOrder = inOrder(out);
        inOrder.verify(out).println("1");
        inOrder.verify(out).println("2");
        inOrder.verify(out).println("fizz");
        inOrder.verify(out).println("4");
        inOrder.verify(out).println("buzz");
        inOrder.verify(out).println("fizz");
        inOrder.verify(out).println("7");
        inOrder.verify(out).println("8");
        inOrder.verify(out).println("fizz");
        inOrder.verify(out).println("buzz");
        inOrder.verify(out).println("11");
        inOrder.verify(out).println("fizz");
        inOrder.verify(out).println("13");
        inOrder.verify(out).println("14");
        inOrder.verify(out).println("fizzbuzz");
    }
}