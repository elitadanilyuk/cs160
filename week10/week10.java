//public class Main {
//    public static void main(String[] args)
//    {
//        Car c1 = new Car("Honda", 2016, "Accord", true);
//
//        Car[] carArray = new Car[5];
//        carArray[0] = c1;
//        carArray[1] = new Car("Subaru", 2019, "WRX", true);
//        for(int c = 2; c < carArray.length; c ++)
//        {
//            carArray[c] = new Car();
//        }
//
//        for(Car i : carArray)
//        {
//            System.out.println(i.getMake() + " \t" + i.getModel());
//        }
//    } // end main()
//} // end Main
//
//class Car
//{
//    private String make;
//    private int year;
//    private String model;
//    private boolean hasOil;
//
//    // this is a constructor
//    // constructors have to have the same name as the class
//    // empty constructor is okay!
//    // datatypes and order of datatypes are what make constructors unique
//    public Car(String make, int year, String model, Boolean hasOil)
//    {
//        this.make = make;
//        this.year = year;
//        this.model = model;
//        this.hasOil = hasOil;
//    }
//
//    public Car()
//    {
//        make = "Honda";
//        year = 2016;
//        model = "Accord";
//        hasOil = true;
//    }
//
//    public String getMake()
//    {
//        return make;
//    }
//
//    public String getModel()
//    {
//        return model;
//    }
//
////    public void oilChanged(boolean oil)
////    {
////        if(oil == false)
////            oil = true;
////    } // end oilChanged
//} // end Car

//public class Main {
//
//    public static void main(String[] args)
//    {
//        Car c1 = new Car("Ford","Mustang");
//        Car c2 = new Car("Toyota", "Corolla");
//
//        System.out.println(c1);
//        System.out.println(c2);
//    }
//
//}
//
//class Car
//{
//    private String make;
//    private String model;
//
//    public Car(String make,String model)
//    {
//        this.make = make;
//        this.model = model;
//    }
//
//    public String toString()
//    {
//        return String.format("Make:\t%s%nModel:\t%s%n",make,model);
//    }
//}

