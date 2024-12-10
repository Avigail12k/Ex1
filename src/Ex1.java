//package assignments.ex1;
/**
 * This class represents a simple solution for Ex1.
 * As defined here: <a href="https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit">...</a>
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     *
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1, sum = 0;
        if (!isNumber(num)) {
            return ans;

        }
        String[] arr = num.split("b");
        String n = arr[0];
        String base = arr[1];
        char numberBase = arr[1].charAt(0);
        for (int j = arr[0].length(); j >= 0; j--) {
            for (int i = 0; i <= arr[0].length(); i++) {
                char number = arr[0].charAt(i);
                int validNumber = index(number);
                sum = (int) (sum + (validNumber * (Math.pow(numberBase, j))));
            }

        }


        // add your code here

        ////////////////////
        return ans;
    }


    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     *
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        boolean ans = true;
        if (a == null || a.isEmpty()) {
            ans = false;
            return ans;
        }
        if (!a.contains("b")) {
            a = a + "bA";
        }
        String regex = "^[0-9A-F]+b[2-9A-G]$";
        if (!a.matches(regex)) {
            ans = false;
        } else {
            String[] arr = a.split("b");
            String num = arr[0];
            String base = arr[1];
            if (arr[1].length() > 1) {
                ans = false;
            } else {
                char numberBase = arr[1].charAt(0);
                for (int i = 0; i <= arr[0].length(); i++) {
                    char number = arr[0].charAt(i);
                    if (index(numberBase) < index(number)) {
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }

    public static int index(char c) {
        char[] validNum = {'A', 'B', 'C', 'D', 'F', 'G'};
        int n = 0;
        for (int i = 0; i <= validNum.length; i++) {
            if (c == validNum[i]) {
                return i + 10;
            }
            n = (int) c;

        }
        return n;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     *
     * @param num  the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        String ans = "";
        String number = Integer.toString(num);
        String base2 = Integer.toString(base);
        String b = "b";
        String newNumber = number + b + base2;
        if (!isNumber(newNumber)) {
            return ans;
        }
        String s = "";
        for (int i = 0; i <= 0; i++) {
            int newNum = (num / base);
            int rest = (num % base);
            String newRest = Integer.toString(rest);
            s += newRest;
            if (newNum == 0) {
                break;
            }
        }
        StringBuilder reversed = new StringBuilder(s);
        reversed.reverse();
        return ans;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;
        if (n1.equals(n2)) {
            return ans;
        }
        ans = false;
        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        for (int i = 0; i <= arr.length; i++) {
            if (number2Int(arr[i]) < number2Int(arr[i + 1])) {
                ans = i + 1;
            } else {
                ans = i;
            }
        }
        return ans;

    }
}