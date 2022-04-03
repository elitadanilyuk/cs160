// Elita Danilyuk
// S02664865

import java.io.File;
import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        final int LINE_COUNT = 10000;
        String[][] allSales = new String[LINE_COUNT][2];
        String[][] bikeSales,baconSales,pizzaSales;
        String[][] salesSummary;

        // Read the external file and store all of the sales data
        allSales = Tools.readFile("sales.txt",LINE_COUNT);

        // Summarize only the sales data for products in the
        // products array.
        bikeSales = Tools.getProductSales("bike", allSales);
        baconSales = Tools.getProductSales("Bacon", allSales);
        pizzaSales = Tools.getProductSales("pizza", allSales);

        // Print out sales for products specified in products array
        Tools.printSales(bikeSales);
        Tools.printSales(baconSales);
        Tools.printSales(pizzaSales);

    }// end main

}

class Tools
{
    /**
     * Reads sales data from an external file using the Scanner class
     * and stores the information in a 2D String array.
     * @param filepath The name of the file to read from.
     * @param lineCount The total number of lines in the file to read.
     * @return A String[][] that contains the product name, and the sale amount.
     */
    public static String[][] readFile(String filepath, int lineCount)
    {
        // 2D String array to store the product name, and the sale amount
        // for that product.
        String[][] allSales = new String[lineCount][2];

        try
        {
            // Scanner to read the external file
            Scanner scnr = new Scanner(new File(filepath));

            int i = 0; // to keep track of what line we are reading.
            while (scnr.hasNext())
            {
                String[] parts = parseLine(scnr.nextLine());
                allSales[i] = parts;
                i++;
            }
        } catch (Exception ex) {
            System.out.println("Error reading file: " + ex.toString());
        }

        return allSales;
    } // end readFile()

    /**
     * Parses the current line from scnr into an array of two elements
     * the product name in index 0 and sale amount in index 1
     * @param scnr The current line from scnr in the Scanner class.
     * @return A String[] that holds the product name and the sale amount.
     */
    public static String[] parseLine(String scnr)
    {
        // declaring and initializing parts[]
        String[] parts = new String[2];
        // declaring and initializing strings to null
        String productString = "";
        String saleString = "";

        // for loop to go through each char to concat
        // either the productString or saleString
        for (int k = 0; k < scnr.length(); k++)
        {
            char currChar = scnr.charAt(k);
            if (Character.isLetter(currChar))
            {
                productString = productString.concat(String.valueOf(currChar));
            } else if (Character.isDigit(currChar) || currChar == '.')
            {
                saleString = saleString.concat(String.valueOf(currChar));
            }
        } // end for
        // defining the elements of parts[2]
        parts[0] = productString;
        parts[1] = saleString;

        return parts;
    } // end parseLine()

    /**
     * Gets the specified product type from the Main() and sums up the sales
     * for the specified product.
     * @param currProduct The specified product from Main().
     * @param allSales A String[][] that contains all products and sale amounts.
     * @return A String[][] that holds the total sales for the specified product.
     */
    public static String[][] getProductSales(String currProduct, String[][] allSales)
    {
        // reformatting the paramater currProduct to upper case
        currProduct = currProduct.toUpperCase();
        // declaring and initializing productSum
        double productSum = 0;

        // for loop to go through each product type
        for (int l = 0; l < allSales.length; l++)
        {
            // reformatting the product type in allSales to upper case
            allSales[l][0] = allSales[l][0].toUpperCase();

            // if loop for instances of currProduct equaling the specified product
            if (currProduct.equals(allSales[l][0]))
            {
                // converting the true String into a Double
                String currString = allSales[l][1];
                double currDouble = Double.parseDouble(currString);
                // summing the sales for the specified product
                productSum = productSum + currDouble;
            }
        } // end for

        // converting the double productSum back to a String
        String totalSales = String.valueOf(productSum);

        return new String[][]{{currProduct, totalSales}};
    } // end getProductSales()

    /**
     * Reads the currSales[][] to output the
     * product name and total sales, no returns.
     * @param currSales A String[][] that holds the product name and total sales
     */
    public static void printSales(String[][] currSales)
    {
        // for loop to output the correct elements
        for(int n = 0; n < currSales.length; n++)
        {
            System.out.println(currSales[n][0] + " " + currSales[n][1]);
        } // end for
    } // end get printSales()

}// end class Tools
