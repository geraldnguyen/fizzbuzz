import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void fizzBuzz() {
        var expected = "1 2 FIZZ 4 BUZZ FIZZ 7 8 FIZZ BUZZ 11 FIZZ 13 14 FIZZ BUZZ 16 17 FIZZ 19 BUZZ FIZZ 22 23 FIZZ BUZZ 26 FIZZ 28 29 FIZZ BUZZ 31 32 FIZZ 34 BUZZ FIZZ 37 38 FIZZ BUZZ 41 FIZZ 43 44 FIZZ BUZZ 46 47 FIZZ 49 BUZZ FIZZ 52 53 FIZZ BUZZ 56 FIZZ 58 59 FIZZ BUZZ 61 62 FIZZ 64 BUZZ FIZZ 67 68 FIZZ BUZZ 71 FIZZ 73 74 FIZZ BUZZ 76 77 FIZZ 79 BUZZ FIZZ 82 83 FIZZ BUZZ 86 FIZZ 88 89 FIZZ BUZZ 91 92 FIZZ 94 BUZZ FIZZ 97 98 FIZZ BUZZ";

        var actualList = (new FizzBuzz()).fizzBuzz();
        var actualString = String.join(" ", actualList);

        assertEquals(expected, actualString);
    }

    @Test
    void fizzBuzzStream() {
        var expected = "1 2 FIZZ 4 BUZZ FIZZ 7 8 FIZZ BUZZ 11 FIZZ 13 14 FIZZ BUZZ 16 17 FIZZ 19 BUZZ FIZZ 22 23 FIZZ BUZZ 26 FIZZ 28 29 FIZZ BUZZ 31 32 FIZZ 34 BUZZ FIZZ 37 38 FIZZ BUZZ 41 FIZZ 43 44 FIZZ BUZZ 46 47 FIZZ 49 BUZZ FIZZ 52 53 FIZZ BUZZ 56 FIZZ 58 59 FIZZ BUZZ 61 62 FIZZ 64 BUZZ FIZZ 67 68 FIZZ BUZZ 71 FIZZ 73 74 FIZZ BUZZ 76 77 FIZZ 79 BUZZ FIZZ 82 83 FIZZ BUZZ 86 FIZZ 88 89 FIZZ BUZZ 91 92 FIZZ 94 BUZZ FIZZ 97 98 FIZZ BUZZ";

        var actualList = (new FizzBuzz()).fizzBuzzStream();
        var actualString = String.join(" ", actualList);

        assertEquals(expected, actualString);
    }

    @Test
    void both_Iterative_and_Stream_implementation_are_equivalent() {
        var fb = new FizzBuzz();
        assertEquals(
                fb.fizzBuzz(),
                fb.fizzBuzzStream()
        );
    }

    @Test
    void fizzBuzz_defective_has_no_FIZZBUZZ() {
        var fb = new FizzBuzz();

        assertNotEquals(
                fb.fizzBuzzStream(),
                fb.fizzBuzz_defective()
        );

        assertFalse(fb.fizzBuzz_defective().contains("FIZZ BUZZ"));
    }

    @Test
    void fizzBuzzStream_defective_range_0_99() {
        var fb = new FizzBuzz();

        assertEquals(fb.fizzBuzzStream().size() - 1, fb.fizzBuzzStream_defective().size());

        assertEquals(
                fb.fizzBuzzStream().subList(0, 99),
                fb.fizzBuzzStream_defective().subList(0, 99)
        );
    }
}