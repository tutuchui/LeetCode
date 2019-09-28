import java.util.*;

public class BiliBili {
    String name = "Father";
         static {
             System.out.println("Father Static");
         }
    {
        System.out.println("Father Normal");
    }

    public static void B(){}



         public BiliBili(){
             System.out.println("Father Construct");
         }

    private void b(){
        System.out.println("Father");
    }
}
