import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(fun(2,2));
    }

    public static int fun(int m,int n){
        if(m==0){
            return n + 1;
        }else if(n == 0){
            return fun(m-1,1);
        }else{
            return fun(m-1,fun(m,n-1));
        }
    }
}

