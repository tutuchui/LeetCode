package graduate;

import java.util.Scanner;

public class QiyiB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        if(n == 0){
            System.out.println(String.format("%.5f",0.0));
        }
        int maxRound = Math.round(m/3) + 1;
        int curM = m;
        int result = 0;
        double[] Awin = new double[maxRound];
//
        System.out.println(String.format("%.5f",result));

    }
}
