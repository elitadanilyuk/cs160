import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //creating a Computer ArrayList<> and adding computers with CPU's
        ArrayList<Computer> computers = new ArrayList<>();
        computers.add(new Computer("Dell", 2019,
                (new CPU("AMD", 3400, 4))));
        computers.add(new Computer("Apple", 2020,
                (new CPU("Apple", 3800, 24))));
        computers.add(new Computer("IBM", 2015,
                (new CPU("Intel", 2800, 2))));

        // enhanced for loop to print details of each computer
        for(Computer c: computers)
        {
            System.out.println(c);
        } // end for computers

    } // end main()

} // end class Main

class Computer
{
    // Computer fields/properties
    private String compManufacturer;
    private int yearManufactured;
    private CPU cpu;
    private int RAM;

    public Computer(String compManufacturer, int yearManufactured, CPU cpu)
    {
        this.compManufacturer = compManufacturer;
        this.yearManufactured = yearManufactured;
        this.cpu = cpu;
    } // end constructor

    public Computer(){} // empty constructor for extended CPU class

    public String toString()
    {
        // returns the computer manufacturer and year made then calls on CPU toString()
        return this.compManufacturer + ":" + this.yearManufactured + cpu;
    } // end toString()

} // end class Computer

class CPU extends Computer
{
    // CPU fields/properties
    private final String CPUmanufacturer;
    private final int speed;
    private final int cores;

    public CPU(String CPUmanufacturer, int speed, int cores)
    {
        super();
        this.CPUmanufacturer = CPUmanufacturer;
        this.speed = speed;
        this.cores = cores;
    } // end constructor

    @Override
    public String toString()
    {
        // returns CPU manufacturer, speed and cores
        return  "\n\t" + "CPU Manufacturer: " + CPUmanufacturer +
                "\n\t" + "CPU Speed: " + speed +
                "\n\t" + "CPU Cores: " + cores;
     } // end toString()

} // end class CPU