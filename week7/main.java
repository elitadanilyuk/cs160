// Elita Danilyuk
// S02664865

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        final int POSSIBLE_OUTCOMES = 11;        // the total number of possible outcomes
        Scanner scnr = new Scanner(System.in);   // a Scanner to read user input
        Random rnd = new Random();               // a random number generator to use

        // getting user input for the total number of simulations to run
        int simCount = getSimulationCount(scnr);

        // running the simulation and saving the results
        int[] simResults = simulate(simCount,rnd);

        // getting a summary of the results of the simulation
        int[] summaryStats = getSummaryStats(simResults,POSSIBLE_OUTCOMES);

        // printing out the results of the simulation based on the summary statistics
        printStats(summaryStats,simCount);

    } // end main()

    public static int getSimulationCount(Scanner scnr)
    {
        // method to gather input from user
        System.out.println("Please enter the number of simulations to run: ");
        int simCount = scnr.nextInt();
        // return an int for the total number of simulations to run
        return simCount;
    } // end getSimulationCount()

    public static int[] simulate(int simCount, Random rnd)
    {
        // method to simulate # of dice rolls
        // initializing and defining a new simResults[]
        int[] simResults = new int[simCount];
        // for loop to roll two die and sum the values
        for(int x = 0; x < simCount; x++)
        {
            int dice1 = rnd.nextInt(6)+1;
            int dice2 = rnd.nextInt(6)+1;
            // defining the results to an element in simResults[]
            simResults[x] = dice1 + dice2;
        } // end for loop
        // return an array for the summed values for each roll
        return simResults;
    } // end simulate()

    public static int[] getSummaryStats(int[] simResults, int POSSIBLE_OUTCOMES)
    {
        // declaration/initialization to set new summaryStats[]
        int[] summaryStats = new int[POSSIBLE_OUTCOMES];
        for (int i =0; i < simResults.length; i++)
        {
            // switch case to set summary array
            switch (simResults[i])
            {
                case 2:
                    summaryStats[0]++;
                    break;
                case 3:
                    summaryStats[1]++;
                    break;
                case 4:
                    summaryStats[2]++;
                    break;
                case 5:
                    summaryStats[3]++;
                    break;
                case 6:
                    summaryStats[4]++;
                    break;
                case 7:
                    summaryStats[5]++;
                    break;
                case 8:
                    summaryStats[6]++;
                    break;
                case 9:
                    summaryStats[7]++;
                    break;
                case 10:
                    summaryStats[8]++;
                    break;
                case 11:
                    summaryStats[9]++;
                    break;
                default:
                    summaryStats[10]++;
            }
        } // end for loop
        return summaryStats;
    } // end getSummaryStats()

    public static void printStats(int[] summaryStats, int simCount)
    {
        // method to output the final summarized stats
        // initial output/heading
        System.out.println("Roll\t" + "Count\t\t\t" + "%\n" +
                "====\t" + "===========\t\t" + "======");
        // for loop to put out the summarized stats for each
        for (int i = 0; i < 11; i++)
        {
            double percent = ((double) summaryStats[i] / simCount) * 100;
            // set tabs to the 100 M output, tabs are slightly off for 100,000
            System.out.print((i+2) + "\t\t" + summaryStats[i] + " \t\t");
            System.out.printf("%.2f", percent);
            System.out.print("%\n");
        }
        // final output: the total number of rolls
        System.out.println("Total number of rolls: " + simCount);
    } // end printStats()
} // end class Main
