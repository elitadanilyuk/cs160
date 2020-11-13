//public class Main {
//
//    public static void main(String[] args)
//    {
//        Mage m1 = new Mage("Rand al'Thor",1000,10000,20000);
//        Warrior w1 = new Warrior("Khutulun",8000,8000,10000);
//
//        System.out.println(m1);
//        System.out.println(w1);
//    }
//}
//
//// parent class
//class Character
//{
//    // fields
//    private String name;
//    private int hitpoints;
//
//    // constructors
//    public Character(String name, int hitpoints)
//    {
//        this.name = name;
//        this.hitpoints = hitpoints;
//    }
//
//    // helpers
//    public String toString()
//    {
//        return name + ":" + hitpoints;
//    }
//}
//
//class Mage extends Character
//{
//    // fields
//    private int mana;
//    private int intelligence;
//
//    // constructor
//    public Mage(String name, int hitpoints, int mana, int intelligence)
//    {
//        super(name, hitpoints);
//
//        this.mana = mana;
//        this.intelligence = intelligence;
//    }
//
//    // getters
//    public int getMana(){return mana;}
//    public int getIntelligence(){return intelligence;}
//
//    // helpers
//    // no longer necessary
//}
//
//class Warrior extends Character
//{
//    // fields
//    private int armor;
//    private int rage;
//
//    // constructor
//    public Warrior(String name, int hitpoints, int armor,int rage)
//    {
//        super(name, hitpoints);
//
//        this.armor = armor;
//        this.rage = rage;
//    }
//
//    // getters
//    public int getArmor(){return armor;}
//    public int getRage(){return rage;}
//
//    // helpers
//    // no longer necessary
//}

//public class Main {
//
//    public static void main(String[] args)
//    {
//
//    }
//}
//
//class GroceryItem
//{
//    private String itemName;
//    private double price;
//
//    // Default (empty) constructor
//    public GroceryItem(){}
//
//    public GroceryItem(String itemName, double price)
//    {
//        this.itemName = itemName;
//        this.price = price;
//    }
//
//    public String getItemName()
//    {
//        return itemName;
//    }
//}
//
//class Produce extends GroceryItem
//{
//    int shelfLife;
//
//    public Produce(String itemName, double price, int shelfLife)
//    {
//        super(itemName,price);
//        this.shelfLife = shelfLife;
//    }
//
//    //overridden method
//    @Override
//    public String getItemName()
//    {
//        return "Item Name: " + super.getItemName() + "| Shelf Life: " + this.shelfLife;
//    }
//}

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        // declaration & initialization of an Integer type ArrayList
        ArrayList<Integer> ints = new ArrayList<Integer>();

        // adding three integers to the ArrayList
        ints.add(5);
        ints.add(40);
        ints.add(35);

        // I am aware that these two steps can be put into one
        // I wanted them to be separate for clarity regarding directions
        int intOutput = ints.get(1) + 20;
        System.out.println(intOutput);
    } // end Main()
} // end Main class