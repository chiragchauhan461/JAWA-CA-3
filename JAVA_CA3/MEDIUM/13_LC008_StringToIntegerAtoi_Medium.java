// LeetCode 8 - String to Integer (atoi)
// Java focus: try-catch-finally, NumberFormatException, user-defined exception, overflow check
class LC008_StringToIntegerAtoi {
    // User-defined exception used when the string has no numeric digit.
    static class NoDigitsException extends Exception {
        NoDigitsException(String message) {
            super(message);
        }
    }

    public int myAtoi(String s) {
        if (s == null) return 0;

        int index = 0;
        int length = s.length();
        int sign = 1;
        long number = 0;

        try {
            while (index < length && s.charAt(index) == ' ') index++;

            if (index < length && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
                sign = (s.charAt(index) == '-') ? -1 : 1;
                index++;
            }

            int start = index;
            while (index < length && Character.isDigit(s.charAt(index))) {
                int digit = s.charAt(index) - '0';
                number = number * 10 + digit;

                long signedNumber = number * sign;
                if (signedNumber > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (signedNumber < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                index++;
            }

            if (index == start) {
                throw new NoDigitsException("No digits were found.");
            }

            return (int) (number * sign);
        } catch (NoDigitsException exception) {
            return 0;
        } catch (NumberFormatException exception) {
            return 0;
        } finally {
            // finally executes whether parsing succeeds or an exception is caught.
        }
    }

    public static void main(String[] args) {
        LC008_StringToIntegerAtoi solution = new LC008_StringToIntegerAtoi();
        System.out.println(solution.myAtoi("42"));              // 42
        System.out.println(solution.myAtoi("   -42"));          // -42
        System.out.println(solution.myAtoi("4193 with words")); // 4193
        System.out.println(solution.myAtoi("words and 987"));   // 0
    }
}
