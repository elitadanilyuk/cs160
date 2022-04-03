// Elita Danilyuk
// S02664865

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // File object to read external data
        final File SALES_FILE = new File("sales.txt");
        // ArrayList to hold all sales objects
        List<Sale> allSales = new ArrayList<Sale>();
        // String array to filter only the items of interest out of the file
        final List<String> ITEMS_OF_INTEREST = Arrays.asList("Gloves","Sausages","Bacon");

        // try/catch required since we're reading from a file.
        try
        {
            Scanner scnr = new Scanner(SALES_FILE);
            while(scnr.hasNext())
            {
                // Parsing item and sales amount of of line
                String[] parts = scnr.next().split(",");

                // Creating a new Sale object based on the parsed data from
                // the file.
                Sale newSale = new Sale(parts[0],Double.parseDouble(parts[1]));

                // Adding the Sale object to the List of all Sales only if it
                // is for an item of interest.
                if(ITEMS_OF_INTEREST.contains(newSale.getItem()))
                {
                    allSales.add(newSale);
                }
            }

        }
        catch(Exception ex)
        {
            // Check to make sure you have the sales.txt file
            // in the same directory as your project.
            System.out.println("Error reading file...");
        }

        // Printing out sales totals
        System.out.println(String.format("%-10s%-10s","Item","Total"));
        System.out.println(String.format("%-10s%-10s","========","==========="));
        for(String item : ITEMS_OF_INTEREST)
        {
            double sum = allSales
                    .stream()
                    .filter(s -> s.getItem().equals(item))
                    .mapToDouble(Sale::getSaleAmount)
                    .sum();

            System.out.println(String.format("%-10s$%,.2f",item,sum));
        }
    }// end Main.main()

}// end class Main

class Sale
{
    // fields of the Sale class
    private String item;
    private double saleAmount;

    // Sale constructor
    public Sale(String newSale, double parts)
    {
        this.item = newSale;
        this.saleAmount = parts;
    }// end Sale()

    // getItem() method to return the item name
    public String getItem()
    {
        return item;
    }// end getItem()

    // getSaleAmount() method to return the sale amount
    public double getSaleAmount()
    {
        return saleAmount;
    }// end getSaleAmount()

}// end class Sale
