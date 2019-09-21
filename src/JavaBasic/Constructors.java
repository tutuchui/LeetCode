package JavaBasic;

import java.lang.reflect.Constructor;

public class Constructors {
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("JavaBasic.Student");

        System.out.println("***********所有公有构造方法**************");
        Constructor[] conArray = clazz.getConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*******所有的构造方法（包括：私有、受保护、默认、公有）*************");
        conArray = clazz.getDeclaredConstructors();
        for(Constructor c : conArray){
            System.out.println(c);
        }

        System.out.println("*********************获取公有、无参的构造方法*******************");
        Constructor con = clazz.getConstructor(); // 获取单个"公有的"构造方法
        System.out.println("con = " + con);
        Object object = con.newInstance();

        System.out.println("*****************获取私有构造方法，并调用********************");
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        con.setAccessible(true);
        object = con.newInstance('男');
    }
}
