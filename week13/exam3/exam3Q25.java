import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // Creating a new iPhone 11 device
        Phone iPhone11 = new Phone(
                "Apple",
                "iPhone 11",
                360,
                "Verizon",
                "4G"
        );

        Phone iPhone12 = new Phone(
                "Apple",
                "iPhone 12",
                360,
                "Verizon",
                "4G"
        );

        // Creating a new Samsung Galaxy 10 device
        Tablet galaxy = new Tablet(
                "Samsung",
                "Galaxy 10",
                360,
                "802.11ac",
                true
        );

        // Creating accessories
        Accessory case1 = new Accessory("Defender","Black","Case");
        Accessory case2 = new Accessory("Commuter","Blue","Case");
        Accessory headphones = new Accessory("Beats","White","Headphones");

        // Assigning supported devices to accessories
        case1.addSupportedDevice(iPhone11.name);
        case1.addSupportedDevice(iPhone12.name);
        case2.addSupportedDevice(iPhone11.name);
        case2.addSupportedDevice(iPhone12.name);
        headphones.addSupportedDevice(iPhone11.name);
        headphones.addSupportedDevice(iPhone12.name);
        headphones.addSupportedDevice(galaxy.name);

        // Tests / printing out results / output
        System.out.println("Checking " + iPhone11 + " for " + case1);
        System.out.println("\t" + case1.isSupportedDevice(iPhone11.name));

        System.out.println("Checking " + iPhone12 + " for " + case2);
        System.out.println("\t" + case1.isSupportedDevice(iPhone11.name));

        System.out.println("Checking " + iPhone12 + " for " + case2);
        System.out.println("\t" + case1.isSupportedDevice(iPhone11.name));

        System.out.println("Checking " + galaxy + " for " + headphones);
        System.out.println("\t" + headphones.isSupportedDevice(galaxy.name));

        System.out.println("Checking " + galaxy + " for " + case1);
        System.out.println("\t" + case1.isSupportedDevice(galaxy.name));
    }

} // end class Main

// Parent class
class Device
{
    // fields/properties
    private String manufacturer;
    private String model;
    /* this cannot be a final because the name changes
            cannot be put within a getter for access because of the main(),
            which cannot be changed
       I tried to make this a final but kept running into syntax error
       I think a google search could have helped me, as I didn't have notes
            for finals, but wanted to stay honest to the exam and my work. */
    public final String name;
    private int warrantyTerm;

    public Device(String manufacturer, String model, int warrantyTerm)
    {
        this.manufacturer = manufacturer;
        this.model = model;
        this.name = manufacturer + " " + model;
        this.warrantyTerm = warrantyTerm;
    } // end constructor

    public Device(){} // empty constructor for some inherited classes

    public String getName()
    {
        return name;
    } // end getName()

    public String toString()
    {
        return name;
    } // end toString()

} // end class Device

class Phone extends Device
{
    // fields/properties
    private String phone;
    private String networkTech;

    public Phone(String manufacturer, String model, int warrantyTerm,
                 String phone, String networkTech)
    {
        super(manufacturer, model, warrantyTerm);
        this.phone = phone;
        this.networkTech = networkTech;
    } // end constructor

} // end class Phone

class Tablet extends Device
{
    // fields/properties
    private String WIFI_networking;
    private boolean hasHeadphoneJack;

    public Tablet(String manufacturer, String model, int warrantyTerm,
                  String WIFI_networking, boolean hasHeadphoneJack)
    {
        super(manufacturer, model, warrantyTerm);
        this.WIFI_networking = WIFI_networking;
        this.hasHeadphoneJack = hasHeadphoneJack;
    } // end constructor

} // end class Tablet

class Accessory extends Device
{
    // fields/properties
    private String name;
    private String color;
    private String type;
    private ArrayList<String> supportedDevices = new ArrayList<>();

    public Accessory(String name, String color, String type)
    {
        super();
        this.name = name;
        this.color = color;
        this.type = type;
    } // end constructor

    public void addSupportedDevice(String name)
    {
        supportedDevices.add(name);
    } // end addSupportedDevice()

    public boolean isSupportedDevice(String name)
    {
        for(int i = 0; i < supportedDevices.size(); i++)
        {
            if(name.equals(supportedDevices.get(i)))
            {
                return true;
            }
        } // end for
        return false;
    } // end isSupportedDevice()

    @Override
    public String toString()
    {
        // returns the parent toString and name & color of Accessory
        return name + ":" + color;
    } // end overridden toString()

} // end class Accessory