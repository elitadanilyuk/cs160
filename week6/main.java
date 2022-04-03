// Elita Danilyuk
// S02664865

import java.io.File;      // used to represent a file on a disk
import java.util.Scanner; // for scanning/reading data from the file

public class Main
{
    public static void main(String[] args)
    {
        String filePath = "Words.txt";  // the path to the data file that will be read
        /*
            Using a try/catch block to catch any exceptions that may occur
            during IO operations on the file. This is a requirement, as
            many things can happen during IO on a file that would
            abnormally error and end a program early. Without accounting
            for this, the program will not compile.
         */

        try
        {
            // Creating a new Scanner object to read the data from the file
            // line by line. A new File object is also created
            Scanner scnr = new Scanner(new File(filePath));

            // TODO: Your code starts here
            // declaring and initializing totalLine and totalPalindrome
            int totalLine = 0;
            int totalPalindrome =0;
            while(scnr.hasNextLine())
            {
                // incramenting totalLine for stats
                totalLine++;
                // declaring & initializing unsanitizedLine
                String unsanitizedLine = scnr.nextLine();
                // declaring & initilizing sanitizedLine to null
                String sanitizedLine = "";
                // for loop to go through each char in unsanitizedLine
                for(int x = 0; x < unsanitizedLine.length(); x++)
                {
                    // declaring & initializing currChar for if statement
                    char currChar = unsanitizedLine.charAt(x);

                    /* if statement see if currChar is a letter,
                     if true, it gets concated to sanitizedLine*/
                    if (Character.isLetter(currChar))
                    {
                        sanitizedLine = sanitizedLine.concat(String.valueOf(currChar));
                    } // end if
                } // end for
                // converting the sanitizedLine string to all lower case
                sanitizedLine = sanitizedLine.toLowerCase();

                // reversisng the sanitizedLine to a new String, reverse
                String reverse = new StringBuffer(sanitizedLine).reverse().toString();
                /* comparing the sanitizedLine to the reverse
                    if equal, the current palindrome is output */
                if (sanitizedLine.equals(reverse))
                {
                    totalPalindrome++;
                    System.out.println("Palindrome Discovered!!");
                    System.out.println("\t" + "The original word/phrase was\t\t\t\t\t" + ": "
                            + unsanitizedLine);
                    System.out.println("\t" + "The sanitized version of the word/phrase was\t"
                            + ": " + sanitizedLine);
                    System.out.println("\t" + "The reversed version of the word/phrase was\t\t"
                            + ": " + reverse);
                } // end if
            } // end while

            // final output for stats of totalLine and totalPalindrome
            System.out.println("All Lines Have Been Read!!\n" + "\t"
                    + "The total number of lines read was: " + totalLine);
            System.out.println("Total Number of Palindromes Found: " + totalPalindrome);
        }
        catch(Exception ex)
        {
            // if an error occurred, printing out details of that
            // error to the console.
            System.out.println("An error occured: " + ex.toString());
        } // end try/catch

    } //end main() method

} // end class Main
