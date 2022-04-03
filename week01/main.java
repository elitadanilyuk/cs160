// Elita Danilyuk
// S02664865

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        // Create a new Scanner to scan and read user input from the standard input (System.in)
        Scanner scnr = new Scanner(System.in);

        // Prompt the user for the desired input, in this case, First Name
        System.out.print("Enter your First Name:");

        // Print out the input from the user for First Name to the console
        System.out.println(scnr.nextLine());

        // Prompt for user to input Middle Name
        System.out.print("Enter your Middle Name:");

        // Print out of the user input for the Middle Name to the console
        System.out.println(scnr.nextLine());

        // Prompt for user to input Last Name
        System.out.print("Enter your Last Name:");

        //Print out of the user input for the Last Name to the console
        System.out.print(scnr.nextLine());
    }
}
