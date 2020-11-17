public class Main
{
    public static void main(String[] args)
    {
        int x = 5;
        System.out.println(factorial(x));

    } // end Main()

    public static int factorial(int start)
    {
        System.out.println("Current start: " + start);

        // this is a base case (this return statement acts almost like a break)
        if(start == 1)
        {
            return 1;
        }

        return start * factorial(start - 1);
    } // end public factorial()

} // end class Main
