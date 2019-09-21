package JavaBasic;

import java.lang.reflect.Method;

public class MethodClass {
    public static void main(String[] args) throws Exception{
        Class stuClass = Class.forName("JavaBasic.Student");
        System.out.println("***************获取所有的公有方法***************");
        Method[] methodArray = stuClass.getMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }

        System.out.println("***************获取所有的方法，包括私有的*****************");
        methodArray = stuClass.getDeclaredMethods();
        for(Method m : methodArray){
            System.out.println(m);
        }

        System.out.println("****************获取公有show1()方法******************");
        Method m = stuClass.getMethod("show1",String.class);
        System.out.println(m);
        Object obj = stuClass.getConstructor().newInstance();
        m.invoke(obj,"刘德华");

        System.out.println("***************获取私有show4()方法*******************");
        m = stuClass.getDeclaredMethod("show4",int.class);
        System.out.println(m);
        m.setAccessible(true);
        Object result = m.invoke(obj,20);
        System.out.println("返回值："+result);

    }
}
