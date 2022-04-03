// Elita Danilyuk
// S02664865

import java.util.Scanner;
import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        // create a new Scanner() to scan and read user input
        Scanner input = new Scanner(System.in);

        // string declarations and definitions
        String opt1 = "Two of a Kind";
        String opt2 = "Three of a Kind";
        String opt3 = "Four of a Kind";
        String guessMsg = "You guessed ";
        String successMsg = " and you were correct!";
        String failMsg = ", but you didn't roll it. Try again!";

	    // Introduction & Input
        System.out.println("What is your prediction?\n" +
                "----------------------------\n" +
                "(1) " + opt1 +
                "\n(2) " + opt2 +
                "\n(3) " + opt3 +
                "\n----------------------------\n" +
                "Enter a number: ");
        int x = input.nextInt();

        if (x == 1) // if/else to output selected option
        {
            System.out.println("The user selected option (" + x +
                    "), " + opt1 + "!");
        }
        else if (x == 2)
        {
            System.out.println("The user selected option (" + x +
                    "), " + opt2 + "!");
        }
        else
        {
            System.out.println("The user selected option (" + x +
                    "), " + opt3 + "!");
        } // end if/else to output selected option

        final int MIN = 1; // The minimum possible integer value
        final int MAX = 6; // The maximum possible integer value

        // Creates a new instance of a Random object from the Random class
        Random rnd = new Random();
        int dice1 = rnd.nextInt((MAX - MIN) + 1) + MIN;
        int dice2 = rnd.nextInt((MAX - MIN) + 1) + MIN;
        int dice3 = rnd.nextInt((MAX - MIN) + 1) + MIN;
        int dice4 = rnd.nextInt((MAX - MIN) + 1) + MIN;

        // output for results
        System.out.println("The results of the roll are " + dice1 +
                "," + dice2 + "," + dice3 + "," + dice4 + "!");

        // if/else to determine if guess was correct
        if ((dice1 == dice2) && (dice2 == dice3) && (dice3 == dice4))
        {
            if (x == 3)
            {
                // output you were correct
                System.out.println(guessMsg + opt3 + successMsg);
            }
            else if (x == 2)
            {
                // output try again
                System.out.println(guessMsg + opt2 + failMsg);
            }
            else
            {
                System.out.println(guessMsg + opt1 + failMsg);
            } // end if/else x == 3
        }
        else if (((dice1 == dice2) && (dice1 == dice3)) ||
                ((dice1 == dice2) && (dice1 == dice4)) ||
                ((dice1 == dice3) && (dice1 == dice4)) ||
                ((dice2 == dice3) && (dice2 == dice4)))
        {
            if (x == 2)
            {
                // output you were correct
                System.out.println(guessMsg + opt2 + successMsg);
            }
            else if (x ==3)
            {
                // output try again
                System.out.println(guessMsg + opt3 + failMsg);
            }
            else
            {
                // output try again
                System.out.println(guessMsg + opt1 + failMsg);
            } // end if/else x == 2
        }
        else if ((dice1 == dice2) || (dice1 == dice3) || (dice1 == dice4) ||
                (dice2 == dice3) || (dice2 == dice4) || (dice3 == dice4))
        {
            if (x == 1)
            {
                // output you were correct
                System.out.println(guessMsg + opt1 + successMsg);
            }
            else if (x == 2)
            {
                // output try again
                System.out.println(guessMsg + opt2 + failMsg);
            }
            else
            {
                // output try again
                System.out.println(guessMsg + opt3 + failMsg);
            } // end if/else x == 1
        }
        else
        {
            if (x == 1)
            {
                // output try again
                System.out.println(guessMsg + opt1 + failMsg);
            }
            else if (x == 2)
            {
                // output try again
                System.out.println(guessMsg + opt2 + failMsg);
            }
            else
            {
                // output try again
                System.out.println(guessMsg + opt3 + failMsg);
            } // end if/else for failed messages
        } // end if/else to determine if guess was correct
    } // end Class
} // end Main()
