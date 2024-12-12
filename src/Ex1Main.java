//package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
import java.util.Scanner;

public class Ex1Main
{
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            String num1 = "", num2 = "", quit = "quit";

            while (!num1.equals(quit) && !num2.equals(quit)) { //Theloop will run as long as the values arent equal to quit
                System.out.println();
                System.out.println("Ex1 class solution:");
                System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
                num1 = sc.next();
                int num1Int = Ex1.number2Int(num1); //The activity sends the value to a function that returns his decimal value
                if (num1.equals(quit)) break; //the  activity checks if the  member put quit and if he did it will go out of the loop
                System.out.println("num value = " + num1Int);
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();
                int num2Int = Ex1.number2Int(num2);
                if (num2.equals(quit)) break;
                System.out.println("num value = " + num2Int);
                System.out.println("Enter an calcAction (+, -, *, /) or \"quit\" to end: "); //the program will ask the user to choose the mathematical equation that he chose
                String calcAction  = sc.next();
                if (calcAction.equals(quit)) break;

                int result = 0; // the difference stores the result of the calculator
                boolean validCalcAction = true; // validates the value
                                                 // validates the calculators that the user enter
                switch (calcAction) {
                    case "+":
                        result = num1Int + num2Int;
                        break;
                    case "-":
                        result = num1Int - num2Int;
                        break;
                    case "*":
                        result = num1Int * num2Int;
                        break;
                    case "/":
                        if (num2Int != 0) {
                            result = num1Int / num2Int;
                        } else {
                            System.out.println("Error: Cannot divide by zero!");
                            validCalcAction = false;
                        }
                        break;
                    default:
                        System.out.println("Invalid operation. Please enter one of (+, -, *, /).");
                        validCalcAction = false;
                        break;
                }


                if (validCalcAction) {
                    System.out.println("Result: " + result);
                }
            }

            System.out.println("quiting now...");
        }
    }

