package JavaBasic;

public class Fanshe {
    public static void main(String[] args) {
        /********************* 3 Basic Methods to get the class object *********************/
        Student stu1 = new Student();
        Class stuClass = stu1.getClass(); //Method 1, 获取Student对象
        System.out.println(stuClass.getName());

        Class stuClass2 = Student.class; //Method 2
        System.out.println(stuClass == stuClass2);

        try{
            Class stuClass3 = Class.forName("JavaBasic.Student"); //Method 3
            System.out.println(stuClass3 == stuClass2);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
