// Elita Danilyuk
// S02664865

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        final String FILE_NAME = "map.txt";
        ArrayList<MapItem> mapItems = new ArrayList<>();

        // Initializing X & Y to keep track of item coordinates
        int X = 0;
        int Y = 0;

        try
        {
            // Scanner to read map data from file
            Scanner scnr = new Scanner(new File(FILE_NAME));

            while(scnr.hasNextLine())
            {
                // Looping through characters in the line
                for(char c: scnr.nextLine().toCharArray())
                {
                    switch(c)
                    {
                        case 'B':
                            // TODO: Create a new Bush (Name = Burning Bush)and add it to the mapItems ArrayList
                            Bush burningBush = new Bush("Bush", X, Y, "Burning Bush");
                            mapItems.add(burningBush);
                            break;
                        case 'L':
                            // TODO: Create a new Bush (Name = Lilac) and add it to the mapItems ArrayList
                            Bush lilac = new Bush("Bush", X, Y, "Lilac");
                            mapItems.add(lilac);
                            break;
                        case 'F':
                            // TODO: Create a new Tree (Name = Fir) and add it to the mapItems ArrayList
                            Tree fir = new Tree("Tree", X, Y, "Fir");
                            mapItems.add(fir);
                            break;
                        case 'R':
                            // TODO: Create a new Tree (Name = Redbud) and add it to the mapItems ArrayList
                            Tree redbud = new Tree("Tree", X, Y, "Redbud");
                            mapItems.add(redbud);
                            break;
                        default:
                            // TODO: Create a new empty MapItem (Type = Empty) and add it to the mapItems ArrayList.
                            MapItem empty = new MapItem("Empty", X, Y);
                            mapItems.add(empty);

                    }// end switch type

                    X++; // Incrementing X within for scnr.hasNext() loop to count each element in a line

                }// end while scnr.hasNext()

                Y++; // Incrementing Y within while scnr.hasNextLine() loop to count the row/line value

                X = 0; // Resetting X to 0, to restart counting for each element in a new line

            }// end while scnr.hasNextLine()

        }
        catch(FileNotFoundException ex)
        {
            System.out.println("There may have been an issue with reading the file.");
        }
        catch(Exception ex)
        {
            System.out.println("Other exception at runtime in your code..debug...");
        }

        // Printing the map of objects
        for(MapItem m: mapItems)
        {
            System.out.println(m);
        }
    } // end Main()
} // end Main class

class MapItem
{
    // class MapItem fields/properties
    public final String type;
    public final int X;
    public final int Y;

    // Constructor method
    public MapItem(String type, int X, int Y)
    {
        this.type = type;
        this.X = X;
        this.Y = Y;
    } // end MapItem()

    public String toString()
    {
        // Returns the MapItem type and its coordinates
        return this.type + ": (" + X + "," + Y + ")";
    } // end toString()

} // end class MapItem

class Bush extends MapItem
{
    // class MapItem fields/properties
    public final String bushName;

    // Constructor method
    public Bush(String type, int X, int Y, String bushName)
    {
        super(type, X, Y);
        this.bushName = bushName;
    } // end Bush()

    @Override
    public String toString()
    {
        // Returns the MapItem type ("Bush"), its coordinates & the bushName
        return super.toString() + ":" + bushName;
    } // end overridden toString()

} // end class Bush

class Tree extends MapItem
{
    // class MapItem fields/properties
    public final String treeName;

    // Constructor method
    public Tree(String type, int X, int Y, String treeName)
    {
        super(type, X, Y);

        this.treeName = treeName;
    } // end Tree()

    @Override
    public String toString()
    {
        // Returns the MapItem type ("Tree"), its coordinates & the treeName
        return super.toString() + ":" + treeName;
    } // end overridden toString()

} // end class Tree
