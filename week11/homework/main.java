// Elita Danilyuk
// S02664865

import java.time.LocalDate;
import java.time.Period;

public class Main {

    public static void main(String[] args)
    {
        Person mainPerson = new Person("Dex","Sharpe","2011-08-13",3);

        mainPerson.addFriend(new Person("Chace","Sharpe","2009-03-28",3));
        mainPerson.addFriend(new Person("Gus","Sharpe","2006-04-09",3));
        mainPerson.addFriend(new Person("Hadlee","Sharpe","2018-05-25",3));

        for(Person p: mainPerson.getFriends())
        {
            System.out.println(p);
        }
    }
}

class Person
{
    //class fields/properties
    private String firstName;
    private String lastName;
    private String birthday;
    private Person[] friends;
    private int friendsCount;

    //constructor method
    public Person(String firstName, String lastName, String birthday, int friendsSize)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.friends = new Person[friendsSize];
        this.friendsCount = 0;
    } //end Person()

    private String getFirstName()
    {
        //Returns the first name of the Person
        return this.firstName;
    } //end getFirstName()

    private String getLastName()
    {
        //Returns the last name of the Person
        return this.lastName;
    } //end getLastName()

    private int getAgeYears()
    {
        LocalDate date = LocalDate.parse(this.birthday);

        //Returns the age of the Person
        return Period.between(date, LocalDate.now()).getYears();
    } //end getAgeYears()

    public void addFriend(Person newFriend)
    {
        //if statement to place a newFriend into the next empty array element
        if(friendsCount < friends.length)
        {
            friends[friendsCount] = newFriend;
            friendsCount++;
        }
    } //end addFriend()

    public Person[] getFriends()
    {
        //Returns the array of friends
        return friends;
    } //end getFriends();

    public String toString()
    {
        //Returns the first and last names and age of the person
        return getFirstName() + ":" + getLastName() + ":" + getAgeYears();
    } //end toString()

} //end Person class
