// Elita Danilyuk
// S02664865

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        String[] testMazes = {"maze1.txt","maze2.txt","maze3.txt"};

        for(String testMaze : testMazes)
        {
            Maze newMaze = new Maze(testMaze);
            newMaze.printMap();

            MazeRunner mr = new MazeRunner(newMaze);
            mr.runMaze();
            mr.printPath();
        }

    } // end main()
} // end class Main

/**
 * class Maze reads a file name consisting of MapItems ('X' (walls), ' ' (blanks), 'e' (entry) and 'q' (exit)).
 * Maze creates, stores and retrieves the Maze, contains method to print the 'Maze'/Map.
 */
class Maze
{
    // TODO: NEXT, AFTER MapItems
    // class Maze fields/properties
    private final String FileName;
    private MapItem entry;
    private MapItem exit;
    private ArrayList<MapItem> mapItems;

    /**
     * Constructor method for class Maze.
     *
     * @param FileName String value of the file name to be read
     */
    public Maze(String FileName)
    {
        this.FileName = FileName;
    } // end constructor Maze()

    /**
     * toString() to print out returns and debugging.
     *
     * @return FileName String of the current file name
     * @return entry MapItem to output its coordinates
     * @return exit MapItem to output its coordinates
     */
    public String toString()
    {
        return this.FileName +
                "\nEntry: " + this.entry +
                "\nExit: " + this.exit;
    } // end toString()

    /**
     * printMap() takes the current FileName, scans the file per line, per char to create a new ArrayList<MapItem>.
     * While also concatenating String printMap to print after coordinates.
     *
     * No return, but outputs the toString() and the concatenated printMap variable.
     */
    public void printMap()
    {
        // Creating a new mapItems ArrayList<MapItem>
        this.mapItems = new ArrayList<>();

        // Declaring & Initializing X & Y to track item coordinates
        int X = 0;
        int Y = 0;
        // Declaring & Initializing printMap to create a concatenated String of MapItems to print
        String printMap = "";

        try
        {
            // Scanner to read map data from file
            Scanner scnr = new Scanner(new File(FileName));

            while(scnr.hasNextLine())
            {
                // Looping through characters in the Line
                for(char c: scnr.nextLine().toCharArray())
                {
                    if(c == 'e')
                    {
                        MapItem entry = new MapItem('e', X, Y);
                        mapItems.add(entry);
                        this.entry = entry;
                    }
                    else if(c == 'q')
                    {
                        MapItem exit = new MapItem('q', X, Y);
                        mapItems.add(exit);
                        this.exit = exit;
                    }
                    else if (c == ' ')
                    {
                        mapItems.add(new MapItem(' ', X, Y));
                    }
                    else
                    {
                        mapItems.add(new MapItem('X', X, Y));
                    }

                    X++; // Incrementing X within for scnr.hasNext() loop to count each element in a line

                    printMap = printMap + c; // Concatenating printMap with the current char

                } // end for char

                Y++; // Incrementing Y within while scnr.hasNextLine() loop to count the row/line value

                X = 0; // Resetting X to 0, to restart counting for each element in a new line

                printMap = printMap + "\n"; // Concatenating printMap with a new line for each new line

            } // end while scnr.hasNextLine()
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("There may have been an issue with reading the file.");
        }
        catch(Exception ex)
        {
            System.out.println("Other exception at runtime in your code...debug...");
        }

        // Printing the 'Maze'/Map of items
        System.out.print(toString() + "\n" + printMap);

        } // end printMap()

    /**
     * getMapItems() takes in two integers, loops through the ArrayList<MapItem> to find the correct MapItem
     * and returns that MapItem.
     *
     * @param X int for the x-coordinate
     * @param Y int for the y-coordinate
     *
     * @return itemFound correct MapItem with appropriate coordinates
     */
    public MapItem getMapItem(int X, int Y)
    {
        // Declaring & Initializing local method variable to null
        MapItem itemFound = null;

        // for(mapItems) to find item
        for (MapItem mapItem : mapItems)
        {
            // if to match X and Y coordinates with correct mapItem
            if ((mapItem.X == X) && (mapItem.Y == Y))
            {
                itemFound = mapItem; // Setting itemFound to the correct mapItem
                break;
            }
        } // end for()

        return itemFound; // returning the correct found mapItem

    } // end getMapItem()

    /**
     * getEntry() gets and returns the current entry coordinates and type or the current MapItem.
     *
     * @return entry MapItem coordinates and type of the current MapItem
     */
    public MapItem getEntry()
    {
        return this.entry;
    } // end getEntry()

    /**
     * getMapItems() gets and returns the current MapItem ArrayList or mapItems.
     *
     * @return mapItems ArrayList or the current MapItem
     */
    public ArrayList<MapItem> getMapItems()
    {
        return this.mapItems;
    } // end getMapItems()

} // end class Maze

/**
 * class MapItem is a 'block' in the class Maze. Each is represented by a type
 * ('X' (walls), ' ' (blanks), 'e' (entry) and 'q' (exit).
 * Each MapItem contains an X & Y coordinate.
 */
class MapItem
{
    // TODO: START HERE
    // class MapItems fields/properties
    private final char type;
    public final int X;
    public final int Y;
    private boolean isVisited;

    /**
     * MapItem() constructor method to set the class values.
     *
     * @param type char for the current MapItem type
     * @param X int for the current X-coordinate
     * @param Y int for the current Y-coordinate
     */
    public MapItem(char type, int X, int Y)
    {
        this.type = type;
        this.X = X;
        this.Y = Y;
        this.isVisited = false;
    } // end constructor MapItem()

    /**
     * toString() to print out returns and debugging.
     *
     * @return (X, Y) coordinates in this formatting (from int X and int Y)
     */
    public String toString()
    {
        return "(" + this.X + "," + this.Y + ")";
    } // end toString()

    /**
     * getType() getter method to access the current MapItem type.
     *
     * @return type char
     */
    public char getType()
    {
        return type;
    } // end getType()

    /**
     * setIsVisited() takes in a boolean to set a MapItem as visited (true) or not visited (false).
     *
     * @param isVisited boolean to set the MapItem as such
     */
    public void setIsVisited(boolean isVisited)
    {
        this.isVisited = isVisited;
    } // end setIsVisited

    /**
     * getIsVisited() returns the boolean value (if the current MapItem is visited --> true).
     *
     * @return isVisited boolean value
     */
    public boolean getIsVisited()
    {
        return this.isVisited;
    } // end getIsVisited()

} // end class MapItems

/**
 * class MazeRunner represents an object that navigates the Maze currMaze.
 * Begins at the entry 'e' and navigates till the exit 'q' is located.
 * MazeRunner can ONLY navigate through single blocks and empty ' ' blocks.
 * Tracks totalSteps, current facing direction and current position (X, Y).
 */
class MazeRunner
{
    // TODO: FINISH HERE
    // class Maze fields/properties
    private final Maze currMaze;
    private int totalSteps = 0;
    private char currDirection;
    private MapItem currPosition;

    /**
     * MazeRunner() constructor method to set the class values.
     *
     * @param currMaze Maze for the current Maze that will be run
     */
    public MazeRunner(Maze currMaze)
    {
        this.currMaze = currMaze;
        this.currDirection = 'E';
        this.currPosition = currMaze.getEntry();
    } // end constructor MazeRunner()

    /**
     * runMaze() runs the current Maze starting at the entry ('e') until the exit ('q').
     * MazeRunner CANNOT move through walls, go over walls, go outside of the Maze while navigating
     * one block/step at a time.
     */
    public void runMaze()
    {
        // while() current position != the exit
        while(currPosition.getType() != 'q')
        {
            // Defining local method variables to track direction to be taken
            MapItem left;
            MapItem forward;
            MapItem right;

            // Switch case currDirection (North, East, South, West)
            // to see coordinates of MapItem to the left, forward & right
            switch (currDirection)
            {
                case 'N':
                    left = currMaze.getMapItem(currPosition.X - 1, currPosition.Y);
                    forward = currMaze.getMapItem(currPosition.X, currPosition.Y - 1);
                    right = currMaze.getMapItem(currPosition.X + 1, currPosition.Y);
                    break;
                case 'E':
                    left = currMaze.getMapItem(currPosition.X, currPosition.Y - 1);
                    forward = currMaze.getMapItem(currPosition.X + 1, currPosition.Y);
                    right = currMaze.getMapItem(currPosition.X, currPosition.Y + 1);
                    break;
                case 'S':
                    left = currMaze.getMapItem(currPosition.X + 1, currPosition.Y);
                    forward = currMaze.getMapItem(currPosition.X, currPosition.Y + 1);
                    right = currMaze.getMapItem(currPosition.X - 1, currPosition.Y);
                    break;
                default:
                    // West
                    left = currMaze.getMapItem(currPosition.X, currPosition.Y + 1);
                    forward = currMaze.getMapItem(currPosition.X - 1, currPosition.Y);
                    right = currMaze.getMapItem(currPosition.X, currPosition.Y - 1);
            } // end switch(currDirection)

            // if/elseif to decide whether to step left, forward, right or turn-around
            if (left.getType() == ' ' || left.getType() == 'q')
            {
                // Switch case to change currDirection to the left of curr case
                switch (currDirection)
                {
                    case 'N':
                        currDirection = 'W';
                        break;
                    case 'E':
                        currDirection = 'N';
                        break;
                    case 'S':
                        currDirection = 'E';
                        break;
                    default:
                        currDirection = 'S';
                } // end switch(currDirection)

                totalSteps++; // Incrementing totalSteps
                currPosition = left; // Updating currPosition to current left coordinate
                left.setIsVisited(true); // Updating left position to visited

            } // end if left
            else if (forward.getType() == ' ' || forward.getType() == 'q')
            {
                totalSteps++; // Incrementing totalSteps
                currPosition = forward; // Updating currPosition to current forward coordinate
                forward.setIsVisited(true); // Updating forward position to visited

            } // end if forward
            else if (right.getType() == ' ' || right.getType() == 'q')
            {
                // Switch case to change currDirection to the right of curr case
                switch (currDirection)
                {
                    case 'N':
                        currDirection = 'E';
                        break;
                    case 'E':
                        currDirection = 'S';
                        break;
                    case 'S':
                        currDirection = 'W';
                        break;
                    default:
                        //West
                        currDirection = 'N';
                } // end switch(currDirection)

                totalSteps++; // Incrementing totalSteps
                currPosition = right; // Updating currPosition to current right coordinate
                right.setIsVisited(true); // Updating right position to visited
            } // end if right
            else // MazeRunner needs to turn-around
            {
                // Switch case to change currDirection to its opposite (turning it around)
                switch (currDirection)
                {
                    case 'N':
                        currDirection = 'S';
                        break;
                    case 'E':
                        currDirection = 'W';
                        break;
                    case 'S':
                        currDirection = 'N';
                        break;
                    default:
                        //West
                        currDirection = 'E';
                } // end switch(currDirection)

            } // end if/elseif to decide whether to step left, forward, right or turn-around

        } // end while() current position != the exit (MazeRunner located 'q')

    } // end runMaze()

    /**
     * printPath() to print the path taken by MazeRunner with "*" for the path (' ')
     * and " " for the walls ('X').
     */
    public void printPath()
    {
        // Declaring & Initializing local method variable to track row numbers for printing new lines
        int rowNum = 0;

        // for(mapItems) to loop through each MapItem for printing
        for(MapItem m: currMaze.getMapItems())
        {
            if(m.Y == rowNum) // if in current rowNum, don't print new line
            {
                // if/else to print "*" for the path and " " for walls
                if(m.getIsVisited() == true)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                } // end if/else to print "*" for the path and " " for walls

            }
            else // if not in current rowNum
            {
                // Print new line && increase rowNum
                System.out.println();
                rowNum = m.Y;

                // if/else to print "*" for the path and " " for walls
                if(m.getIsVisited() == true)
                {
                    System.out.print("*");
                }
                else
                {
                    System.out.print(" ");
                } // end if/else to print "*" for the path and " " for walls

            } // end if/else if in current rowNum

        } // end for(mapItems)

        // Printing the total number of steps the MazeRunner made
        System.out.println("\nTotal number of steps: " + (totalSteps+1) + "\n");

    } // end printPath()

} // end class MazeRunner