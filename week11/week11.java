public class Main
{
    public static void main(String[] args)
    {
//        Car c1 = new Car();
//        System.out.println(c1);
    }
}

//class Car
//{
//    /*
//    fields: what the program writer can see (ie private)
//    properties: what other programers can see (methods)
//     */
//    private String color;
//    private String make;
//    private String model;
//    private int year;
//
//    public Car()
//    {
//        color = "Blue";
//        make = "Toyota";
//        model = "Corola";
//        year = 2003;
//    }
//    // this is an accessor ("getter") method
//    public String getColor()
//    {
//        return color;
//    }
//
//    // this is a mutator ("setter") method
//    public void setColor(String newColor)
//    {
//        color = newColor;
//    }
//
//    // this is an accessor ("getter") method
//    public String getName()
//    {
//        return make + " " + model;
//    }
//
//    public int getAge()
//    {
//        return age();
//    }
//    // this is a private, local, helper method
//    private int age()
//    {
//        return 100;
//    }
//    // this is a helper method
//    public String toString()
//    {
//        return make + " " + model + " " + color;
//    }
//}

class Hero
{
    private String heroName;
    private String weaponName;

    public Hero(String heroName, String weaponName)
    {
        this.heroName = heroName;
        this.weaponName = weaponName;
    }// end constructor

    public String getHeroName()
    {
        return this.heroName;
    }// end getHeroName()

    public void setWeaponName(String newWeaponName)
    {
        this.weaponName = newWeaponName;
    }// end setWeaponName()

    public String getWeaponName()
    {
        return this.weaponName;
    }// end getWeaponName()

}// end class Hero

class Weapon
{
    private Hero weaponName;
    private int damage;

    public Weapon(int damage)
    {
        this.damage = damage;
    }// end constructor

    public Hero getWeaponName()
    {
        return weaponName;
    }// end getWeaponName()

    public int getDamage()
    {
        return this.damage;
    }// end getDamage()

    public void setWeaponName(Hero weaponName)
    {
        this.weaponName = weaponName;
    }// end setWeaponName
}// end class Weapon