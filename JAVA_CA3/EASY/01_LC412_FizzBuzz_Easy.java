// LeetCode 412 - Fizz Buzz
// Java focus: if-else, for loop, modulo operator, ArrayList<String>
import java.util.ArrayList;
import java.util.List;

class LC412_FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(String.valueOf(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LC412_FizzBuzz solution = new LC412_FizzBuzz();
        System.out.println(solution.fizzBuzz(15));
    }
}
