import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FizzBuzz {
    /*
    For each integer between 1 to 100, print FIZZ if the number is divisible by 3, BUZZ if the number is divisible by 5, and FIZZ BUZZ if the number is divisible by both 3 and 5. Otherwise, just print the number.
     */
    public List<String> fizzBuzz() {
        var output = new ArrayList<String>();

        for (int i = 1; i <= 100; i++) {
            if (i % 15 == 0) {
                output.add("FIZZ BUZZ");
            } else if (i % 3 == 0) {
                output.add("FIZZ");
            } else if (i % 5 == 0) {
                output.add("BUZZ");
            } else {
                output.add(String.valueOf(i));
            }
        }
        return output;
    }

    // Exercise: identify the bugs in below method
    public List<String> fizzBuzz_defective() {
        var output = new ArrayList<String>();

        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0) {
                output.add("FIZZ");
            } else if (i % 5 == 0) {
                output.add("BUZZ");
            } else if (i % 15 == 0) {
                output.add("FIZZ BUZZ");
            } else {
                output.add(String.valueOf(i));
            }
        }
        return output;
    }

    public List<String> fizzBuzzStream() {
        return IntStream.rangeClosed(1, 100)
                .mapToObj(i -> {
                    if (isDivisible(i, 15)) return "FIZZ BUZZ";
                    else if (isDivisible(i, 3)) return "FIZZ";
                    else if (isDivisible(i, 5)) return "BUZZ";
                    else return String.valueOf(i);
                 })
                .collect(Collectors.toList());
    }

    private boolean isDivisible(int number, int operand) {
        return number % operand == 0;
    }

    // Exercise: identify the bugs in below method
    public List<String> fizzBuzzStream_defective() {
        return IntStream.range(1, 100)
                .mapToObj(i -> {
                    if (isDivisible(i, 15)) return "FIZZ BUZZ";
                    else if (isDivisible(i, 3)) return "FIZZ";
                    else if (isDivisible(i, 5)) return "BUZZ";
                    else return String.valueOf(i);
                })
                .collect(Collectors.toList());
    }
}
