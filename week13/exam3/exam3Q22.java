//QUESTION 22
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);
        nums.add(50);

        for(int x: nums)
        {
            System.out.println(x);
        }

        for(int y = 0; y < nums.size(); y++)
        {
            nums.set(y, nums.get(y) + 20);

        }

        for(int z: nums)
        {
            System.out.println(z);
        }

    } // end main()
} // end class Main


//// QUESTION 23 || DONE
//class Main
//{
//    public static void main(String[] args)
//    {
//        Texture t1 = new Texture
//                (
//                        "TEX123",
//                        "Texture",
//                        "./assets/textures/txt123.tx",
//                        1024,
//                        "Surface"
//                );
//
//        Texture t2 = new Texture
//                (
//                        "TEX456",
//                        "Texture",
//                        "./assets/textures/txt456.tx",
//                        1024,
//                        "Player"
//                );
//
//        System.out.println(t1);
//        System.out.println(t2);
//
//    }
//}
//
//class GameAsset
//{
//    public final String ID;
//    public final String type;
//    public final String path;
//
//    public GameAsset(String ID, String type, String path)
//    {
//        this.ID = ID;
//        this.type = type;
//        this.path = path;
//    }
//
//    public String toString()
//    {
//        return this.formatAssetString();
//    }
//
//    private String formatAssetString()
//    {
//        return this.ID + ":" + this.type + ":" + this.path;
//    }
//}
//
//class Texture extends GameAsset
//{
//    private int size;
//    private String textureType;
//
//    public Texture(String ID, String type, String path, int size, String textureType)
//    {
//        super(ID,type,path);
//        this.size = size;
//        this.textureType = textureType;
//    }
//
//    @Override
//    public String toString()
//    {
//        return super.toString() + "|" + this.size + "_KB|" + this.textureType;
//    }
//}
