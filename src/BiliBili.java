import java.util.*;

public class BiliBili {
    String name = "Father";
         static {
             System.out.println("Father Static");
         }

         public BiliBili(){
             System.out.println("Father Construct");
         }

    public void b(){
        System.out.println("Father");
    }
}
