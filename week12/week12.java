import java.sql.SQLOutput;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Student s1 = new Student("Elita", "Danilyuk", "S01234",
                false, 0.0, 12);
        Instructor i1 = new Instructor("Dan", "Danilyuk", "S43210",
                20, 5, "Math",45000.00);
        System.out.println(s1.getName());
        System.out.println(i1.getName());


        // adding to a classic array
        int[] arrayNums = new int[10];
        arrayNums[0] = 3;

        // cannot have a primitive data type
        // ArrayList-->container, <E>-->type, () are for an empty constructor
        ArrayList<Student> students = new ArrayList<Student>();
        // adding indexes to ArrayList
        students.add(new Student("Luna", "Danilyuk", "S89345",
                true, 4.0, 15));
        students.add(new Student("Lucy", "Lucile", "S27345",
                true, 3.5, 6));
        students.add(new Student("Soph", "Kavchak", "S53529",
                false, 2.3, 28));

        // Classic for loop with ArrayList
        for(int i =0; i < students.size(); i++)
        {
            System.out.println(students.get(i));
        }

        // Enhanced for loop with ArrayList
        System.out.println("::::these are in the enhanced for loop::::");
        for(Student s : students)
        {
            System.out.println(s);
        }

        // primitive data types, wrapper classes, ArrayList
        int i = 10;
        Integer i2 = i; // this is BOXING
        Integer i3 = new Integer(i); // EXPLICIT BOXING, not req, deprecated
        char c = 'A';
        Character c1 = c; // this is BOXING
        Character c2 = new Character(c); // EXPLICIT BOXING, not req, deprecated

        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(25);
        ints.add(i);

        // ArrayList UNBOXING behind the scenes
        int i4 = 20;
        int i5 = ints.get(0) + 10;

        // enhanced for loop and unboxing with ArrayList
        for(int x: ints)
        {
            System.out.println(x + 5);
        }

        // ArrayLists and Inheritance
        // Object is the parent class for all objects (it can contain ANY data type)
        ArrayList<Object> objects = new ArrayList<Object>();
        objects.add(3); //behind the scenes is unboxing to Integer class
        objects.add(s1);
        objects.add(i4);
        objects.add(c1);
        objects.add(i1);
        objects.add("This is a String");

        // this ArrayList can contain any "Person" and/or child class of Person
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Sumi", "Thompson", "S41232"));
        persons.add(s1);
        persons.add(i1);

        for(Person p : persons)
        {
            switch(p.getClass().toString())
            {
                case "class Person":
                    System.out.println(p.getName());
                    break;
                case "class Student":
                    // getting a method within a child class
                    // cast p to Student
                    System.out.println(((Student)p).getGPA());
                    break;
                default:
            }
        }
    }
}

class Person
    //anything within a class is a member of that class
    //it can be fields/properties/constructors/methods
{
    //can set a final at time of constructor
    //cannot be redefined, but can still be accessed
    private String fName;
    private String lName;
    private String ID;

    public Person() { }

    public Person(String fName, String lName, String ID)
    {
        this.fName = fName;
        this.lName = lName;
        this.ID = ID;
    }

    public Person(String fName, String lName)
    {
        this.fName = fName;
        this.lName = lName;
        this.ID = "NOT_ASSIGNED";
    }

    public String getName()
    {
        return this.lName + "," + this.fName + " : " + this.ID;
    }

    public String toString()
    {
        return this.lName + "," + this.fName + " : " + this.ID;
    }
} // end Person class

//this is an extension of the Person class
class Student extends Person
{
    private boolean isGraduating;
    private double GPA;
    private int credits;

    public Student(String fName, String lName, String ID, boolean isGraduating,
                   double GPA, int credits)
    {
        super(fName, lName, ID);

        this.isGraduating = isGraduating;
        this.GPA = GPA;
        this.credits = credits;
    }

    public double getGPA()
    {
        return GPA;
    }

    // overriding methods, best practice needs @Override (Doesn't need super....)
    @Override
    public String getName()
    {
        return super.getName() + " : " + this.GPA;
    }
} // end Student class


class Instructor extends Person
{
    private int numStudents;
    private int numClasses;
    private String department;
    private double salary;

    public Instructor(String fName, String lName, String ID, int numStudents,
                      int numClasses, String department, double salary)
    {
        super(fName, lName, ID);

        this.numStudents = numStudents;
        this.numClasses = numClasses;
        this.department = department;
        this.salary = salary;
    }
} // end Instructor class

class Lecturer extends Person
{
    private int yearsInField;
    private String occupation;

    public Lecturer(String fName, String lName, int yearsInField, String occupation)
    {
        super(fName, lName);

        this.yearsInField = yearsInField;
        this.occupation = occupation;
    }
} // end Lecturer class

class Administrator extends Person
{
    private String title;
    private int salary;

    public Administrator(String fName, String lName, String ID, String title, int salary)
    {
        super(fName, lName, ID);

        this.title = title;
        this.salary = salary;
    }
} // end Administrator

class Staff extends Person
{
    private String occupation;

    public Staff(String fName, String lName, String ID, String occupation)
    {
        super(fName, lName, ID);

        this.occupation = occupation;
    }

} // end Staff

class Security extends Person
{
    private String campusLocation;
    private boolean isArmed;

    public Security(String fName, String lName, String campusLocation, boolean isArmed)
    {
        super(fName, lName);

        this.campusLocation = campusLocation;
        this.isArmed = isArmed;
    }
} // end Security