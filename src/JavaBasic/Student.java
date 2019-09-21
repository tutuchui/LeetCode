package JavaBasic;

public class Student {

    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString(){
        return "Student [name= "+name +", age= " + age +", sex = " + sex + ", phoneNum = " + phoneNum + "]";
    }

    Student(String str){
        System.out.println("默认的构造方法 s = " + str);
    }

    public Student(){
        System.out.println("调用了公有，无参构造方法执行");
    }

    public Student(char sex){
        System.out.println("性别: " + sex);
    }

    public Student(String name ,int age){
        System.out.println("姓名："+name+" 年龄："+ age);
    }

    //受保护的构造方法
    protected Student(boolean n){
        System.out.println("受保护的构造方法 n = " + n);
    }

    //私有构造方法
    private Student(int age){
        System.out.println("私有的构造方法   年龄："+ age);
    }

    //Member Method
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }

    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }

    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }

    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = "+age);
        return "abcd";
    }

}
