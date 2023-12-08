
public class Main
{

    public static void main(String[] args)
    {
        Hero h1 = new Hero("Travis",10);
        InventoryItem item1 = new InventoryItem("Sword",10,true);
        InventoryItem item2 = new InventoryItem("HeathPot", 5, false);
        h1.getBackPack().addItem(item1);
        h1.getBackPack().addItem(item2);

        System.out.println(h1);
    }
}

class Hero
{
    private String _name;
    private BackPack bp;

    public Hero(String name, int backpackSize)
    {
        _name = name;
        bp = new BackPack(backpackSize);
    }

    public BackPack getBackPack()
    {
        return bp;
    }

    // Description
    public String toString()
    {
        return _name;
    }

    public String toString(boolean withWeapon)
    {
        return _name + " : " + bp.getItem(0).name();
    }

}

class BackPack
{
    // InventoryItem
    private InventoryItem[] inventory;
    int itemCount;

    public BackPack(int backpacksize)
    {
        inventory = new InventoryItem[backpacksize];
        itemCount = 0;
    }

    public int getSize()
    {
        return inventory.length;
    }

    public boolean addItem(InventoryItem item)
    {
        if(itemCount < getSize())
        {
            inventory[itemCount] = item;
            itemCount++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public InventoryItem getItem(int i)
    {
        return inventory[i];
    }

}

class InventoryItem
{

    private String itemName;
    private int itemSize;
    private boolean isEnchanted;
    //private double dSize;

    public InventoryItem(String inputName, int inputSize, boolean inputIsEnchanted) {
        itemName = inputName;
        itemSize = inputSize;
        isEnchanted = inputIsEnchanted;
    }

    public String name()
    {
        return itemName;
    }

    // rename?
    public String name(String newName)
    {
        itemName = newName;
        return itemName;
    }

    public int invSize()
    {
        return itemSize;
    }

    // changeSize
    public int invSize( int newSize)
    {
        itemSize = newSize;
        return itemSize;
    }
    /*    public double invSize(double newSize)
        {
            dSize = newSize;
            return dSize;
        }*/
    public boolean enchanted()
    {
        return isEnchanted;
    }

    // changeEnchanted
    public boolean enchanted(boolean newEnchanted)
    {
        isEnchanted =newEnchanted;
        return isEnchanted;
    }

    // toString
    public String toString()
    {
        return itemName + " : " + itemSize + " : "+ isEnchanted;
    }
}