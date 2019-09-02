import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = Integer.valueOf(scanner.nextLine());
//        String[] secInp = scanner.nextLine().split(" ");
//        int[] Xi = new int[secInp.length];
//        for(int i = 0; i < secInp.length;i++){
//            Xi[i] = Integer.valueOf(secInp[i]);
//        }
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                int n = Integer.valueOf(input.split(" ")[0]);
                int m = Integer.valueOf(input.split(" ")[1]);
                int k = Integer.valueOf(input.split(" ")[2]);
                int[] resultArr = new int[n * m];

                Arrays.sort(resultArr);

            }
}

