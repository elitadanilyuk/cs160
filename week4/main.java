// Elita Danilyuk
// S02664865

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        final String FILE_PATH = "Words.txt";       // path to file, current project directory
        File callOfTheWild = new File(FILE_PATH);   // File object to read data from file
        int lineCount     = 0;                      // Used to track total lines
        int charCount     = 0;                      // Used to track total characters
        int aCount        = 0;                      // Used to track total 'a's
        int eCount        = 0;                      // Used to track total 'e's
        int iCount        = 0;                      // Used to track total 'i's
        int oCount        = 0;                      // Used to track total 'o's
        int uCount        = 0;                      // Used to track total 'u's
        int spaceCount    = 0;                      // Used to track total of spaces
        int otherCount    = 0;                      // Used to track total of other characters

        try
        {
            // creating a new scanner object to read the file
            Scanner scnr = new Scanner(callOfTheWild);

            // a while loop will check the scanner to see if there is a next line to
            // read or not. hasNextLine() tells the Scanner object to peek to see if
            // there is another line to read from the source. If there is, it returns
            // true, if there isn't (end of the file in this case), then it returns
            // false.

            while(scnr.hasNextLine())
            {
                // reading the next line in the file and storing it in the curLine
                // variable.
                String curLine = scnr.nextLine();

                // Incrementing Line Count
                lineCount++;

                // visiting each char in the curLine String, one by one.
                // the curChar variable will store the value of the current
                // char being evaluated.
                for(char curChar: curLine.toCharArray())
                {
                    // ==================================
                    // TODO:  YOUR CODE STARTS HERE!!!!
                    // ==================================
                    charCount++; //incrementer to count total characters

                    if (curChar == 'a' || curChar == 'A')
                    {
                        aCount++;
                    } // end if(char is letter a)
                    else if (curChar == 'e' || curChar == 'E')
                    {
                        eCount++;
                    } // end if(char is letter e)
                    else if (curChar == 'i' || curChar =='I')
                    {
                        iCount++;
                    } // end if(char is letter i)
                    else if (curChar == 'o' || curChar == 'O')
                    {
                        oCount++;
                    } // end if(char is letter o)
                    else if (curChar == 'u' || curChar == 'U')
                    {
                        uCount++;
                    } // end if(char is letter u)
                    else if (curChar == ' ')
                    {
                        spaceCount++;
                    } // end if(char is a space)
                    else
                    {
                        otherCount++; // default incrementer
                    } // end if statement for counting char
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("Issue reading file");
        }

        // =========================================
        // TODO: YOUR OUTPUT STATEMENTS GO HERE!!!!
        // =========================================
        // sout total lines
        System.out.println("Total lines: " + lineCount);
        // sout total a's & percentage used
        System.out.println("Total a's: " + aCount + " (" +
                (((double)aCount / charCount) *100) + "%)");
        // sout total e's & percentage used
        System.out.println("Total e's: " + eCount + " (" +
                (((double)eCount / charCount) *100) + "%)");
        // sout total i's & percentage used
        System.out.println("Total i's: " + iCount + " (" +
                (((double)iCount / charCount) *100) + "%)");
        // sout total o's & percentage used
        System.out.println("Total o's: " + oCount + " (" +
                (((double)oCount / charCount) *100) + "%)");
        // sout total u's & percentage used
        System.out.println("Total u's: " + uCount + " (" +
                (((double)uCount / charCount) *100) + "%)");
        // initialise and define a vowelsCount
        int vowelsCount = aCount+eCount+iCount+oCount+uCount;
        // sout total vowels & percentage used
        System.out.println("Total vowels: " + vowelsCount + " (" +
                (((double)vowelsCount / charCount) *100) + "%)");
        // sout total spaces  & percentage used
        System.out.println("Total spaces: " + spaceCount + " (" +
                (((double)spaceCount / charCount) *100) + "%)");
        // sout total "others"  & percentage used
        System.out.println("Total others: " + otherCount + " (" +
                (((double)otherCount / charCount) *100) + "%)");
        // sout total characters
        System.out.println("Total characters: " + charCount);
    }
}
