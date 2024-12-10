public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * If the given number is not in a valid format, return -1.
     *
     * @param num a String representing a number in base [2,16]
     * @return
     */
    public static int number2Int(String num)
    {
        int ans = -1, sum = 0;
        if (!isNumber(num)) {
            return ans;
        }

        String[] arr = num.split("b");
        String n = arr[0];  // The number part
        String baseStr = arr[1];  // The base part

        // Convert base from string to numeric value
        int baseValue = index(baseStr.charAt(0));

        // Process each character in the number
        for (int j = n.length() - 1; j >= 0; j--) {
            char number = n.charAt(j);
            int validNumber = index(number);

            // Calculate the sum (using the correct base)
            sum += validNumber * Math.pow(baseValue, n.length() - 1 - j);
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
            ans = false;
            return ans;
        }
        if (!a.contains("b")) {
            a = a + "bA";  // Add default base if missing
        }
        String regex = "^[0-9A-F]+b[2-9A-G]$";  // Regex to check the valid format
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
                for (int i = 0; i < arr[0].length(); i++) {
                    char number = arr[0].charAt(i);
                    if (index(numberBase) < index(number)) {
                        ans = false;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Returns the numeric value corresponding to the given character.
     *
     * @param c The character to convert to its numeric value
     * @return the numeric value of the character
     */
    public static int index(char c) {
        char[] validNum = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int i = 0; i < validNum.length; i++) {
            if (c == validNum[i]) {
                return i + 10;
            }
        }
        // For digits 0-9, directly return the integer value
        return c - '0';
    }

    /**
     * Calculate the number representation (in base) of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16], the function should return "" (the empty String).
     *
     * @param num  the natural number (including 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base)
    {
        if (num < 0 || base < 2 || base > 16) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        while (num > 0) {
            int remainder = num % base;
            result.append(Integer.toString(remainder, base).toUpperCase());
            num = num / base;
        }
        if (result.length() == 0) {
            result.append("0");
        }

        // Reverse and append base information
        return result.reverse().toString() + "b" + base;
    }

    /**
     * Checks if the two numbers have the same value.
     *
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        return number2Int(n1) == number2Int(n2);
    }

    /**
     * This static function searches for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or non-valid numbers (with value -1).
     *
     * @param arr an array of numbers
     * @return the index in the array with the largest number (in value).
     */
    public static int maxIndex(String[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (number2Int(arr[i]) < number2Int(arr[i+1])) {
                ans = i+1;
            }
            else {
                ans=i;
            }
        }
        return ans;
    }
}
