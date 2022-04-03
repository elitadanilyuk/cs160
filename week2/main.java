// Elita Danilyuk
// S02664865

/* Simulation: result 1 = 127.63, result 2 = 161.05, result 3 = 162.89.
    Investing for a longer period of time had a greater impact.
    This is because profits from compound interest are higher over time
    versus a higher interest rate. This is why most people recommend
    getting into investing as early as you can.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // create a new Scanner() to scan and read user input
        Scanner input = new Scanner(System.in);

        // prompt for the user to input the initial principal amount
        System.out.print("Enter the initial principal: ");
        // declaration and initialization of the initial principal from user input
        double p = input.nextDouble();

        // prompt for the user to input the interest rate
        System.out.print("Enter the interest rate: ");
        // declaration and initialization of the interest rate from user input
        double i = input.nextDouble() / 100;

        // prompt for the user to input the input of the number of periods
        System.out.print("Enter the number of periods: ");
        // declaration and initialization of the number of periods from user input
        int t = input.nextInt();

        //  declaration and initialization of multiplier using the Math.pow() method
        double multiplier = Math.pow((1 + i), t);

        // declaration and initialization of the amount of investment
        double inv = p * multiplier;

        // method String.format() to format the investment return to 2 decimal places
        // declaration and initialization of resultStr
        String resultStr = String.format("%.2f", inv);

        // final print out of the resultStr
        System.out.println("The value of the investment is: $" + resultStr);
    }
}
