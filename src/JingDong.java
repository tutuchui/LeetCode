import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class JingDong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        String H = scanner.nextLine();
        String[] HnArray = H.split(" ");
        int[] Hn = new int[N];
        for(int i = 0; i < N; i++){
            Hn[i] = Integer.valueOf(HnArray[i]);
        }
        List<String> result = new LinkedList<>();
        JingDong jingDong = new JingDong();
        jingDong.split(0,Hn,result);
        System.out.println(result.size());
    }


    public void split(int index, int[] array, List<String> result){
        if(index >= array.length){
            return;
        }
        int lIndex = findLessIndex(index,array);
        if(lIndex == -1){
            result.add(index + " ");
            split(index+1,array,result);
        }else{
            result.add(index + "--" + lIndex + " ");
            split(lIndex+1,array,result);
        }


    }

    int findLessIndex(int cur, int array[]){
        int minIndex = -1;
        for(int i = cur + 1; i < array.length; i++){
            if(array[i] < array[cur]){
                minIndex = i;
            }
        }
        return minIndex;
    }
}
