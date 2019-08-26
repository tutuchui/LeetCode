public class DiliDili extends BiliBili {
    static {
        System.out.println("Child static");
    }
    String name = "Child";
    public DiliDili(){
        System.out.println("Child construct");
    }
    public void b(){
        System.out.println("Child");
    }

    public static void main(String[] args) {
        BiliBili b = new DiliDili();
        System.out.println(b.name);
        b.b();
    }
}
