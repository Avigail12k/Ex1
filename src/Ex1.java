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
        if (!num.contains("b")) {
            num = num + "bA";  // If there is no base we will set a default
        }

        if (!isNumber(num)) {
            return ans;  // If num is a invalid number
        }

        String[] arr = num.split("b");
        String n = arr[0];
        String base = arr[1];
        int baseValue = index(base.charAt(0));  // Searching for the base value

        for (int j = n.length() - 1, i = 0; j >= 0 && i < n.length(); j--, i++) {
            char number = n.charAt(i);
            int validNumber = index(number);  // Convert current number to value
            sum += validNumber * Math.pow(baseValue, j);  // Calculating the value in decimals
        }
        ans = sum;
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
            return false;
        }

        if (!a.contains("b")) {
            a = a + "bA"; // If the entered number is decimal, we will represent it in base A (decimal)
        }

        String regex = "^[0-9A-F]+b[2-9A-G]$";  // proper format
        if (!a.matches(regex)) {
            ans = false;
        } else {
            String[] arr = a.split("b");  // Separation between the number and the base into two arrays
            String num = arr[0];
            String base = arr[1];

            if (arr[1].length() > 1 || index(base.charAt(0)) == -1) // Not a valid number
            {
                ans = false;
            }
            else
            {
                char numberBase = arr[1].charAt(0); // Separating a character from the string
                for (int i = 0; i < arr[0].length(); i++) {
                    char number = arr[0].charAt(i);
                    if (index(number) < 0 || index(number) >= index(numberBase)) { // If the number is greater than its base
                        ans = false;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static int index(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0'; // Normal numbers
        }
        char[] validNum = {'A', 'B', 'C', 'D', 'E', 'F', 'G'}; //Converts the character to its value number
        for (int i = 0; i < validNum.length; i++) {
            if (c == validNum[i]) {
                return i + 10;
            }
        }
        return -1;
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
        if (num < 0 || base < 2 || base> 16 ) {
            return ans ;  //Checks the correctness of the numbers
        }

        if (num==0)  //If the number is 0 in every base the value will be 0
        {
            ans = "0";
            return ans;
        }
        if (base==10)  //If the number is decimal there is no need to change it
        {
            ans = String.valueOf(num);
            return ans;
        }
        StringBuilder s = new StringBuilder(); //Constructing a string that can contain large numbers
        while (num > 0) { //As long as the division is not equal to 0
            int rest = num % base; //Residual calculation
            s.append(Integer.toString(rest, base).toUpperCase());  // Concatenate the remainder to a string
            num = num / base;
        }
        s.reverse(); //Reverse concatenation into a string for the answer to be correct
        ans = s.toString() + "b" + Integer.toString(base);
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
        if (n1.equals(n2)) {   // Checking if the strings are the same
            return ans;
        }
        int num1 = number2Int(n1); //Convert the strings to decimal
        int num2 = number2Int(n2); //Convert the strings to decimal

        if (num1 == -1 || num2 == -1) { //If one of the strings is incorrect
            return false;
        }

        return num1 == num2; //Return true if the decimal values are equal
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
        for (int i = 0; i < arr.length - 1; i++)
        {
            int currentNum = number2Int(arr[i]);//Convert the strings to decimal
            int nextNum = number2Int(arr[i + 1]);//Convert the strings to decimal the next value at arr

            if (currentNum == -1 || nextNum == -1) {//If one of the values is invalid
                continue;  // skip
            }

            if (currentNum < nextNum) { //If the next value is greater than the current one
                ans = i + 1;
            } else {  //If the next value is not greater than the current one
                ans = i;  //
                break;
            }
        }
        return ans;
    }
}
