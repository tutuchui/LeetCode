package graduate;

public class DiliDili extends BiliBili {
    static {
        System.out.println("Child static");
    }

    {
        System.out.println("Child Normal");
    }
    String name = "Child";
    public DiliDili(){
        System.out.println("Child construct");
    }

    @Override
    void b(){
        System.out.println("Child");
    }
    
    public static void main(String[] args) {
        BiliBili b = new DiliDili();
        System.out.println(b.name);

//        b.b();
//        System.out.println((int) 3/2);
    }

}
