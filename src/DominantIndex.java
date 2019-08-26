import java.util.Arrays;

public class DominantIndex {
    public int dominantIndex(int[] sums){
        int[] sumS = new int[sums.length];
        for(int i = 0; i < sums.length; i++){
            sumS[i] = sums[i];
        }
        Arrays.sort(sumS);
        if(sumS[sumS.length - 1] >= sums[sumS.length - 2] * 2){
            for(int i = 0; i < sums.length;i++){
                if(sumS[sumS.length - 1] == sums[i]){
                    return i;
                }
            }
            StringBuilder sb = new StringBuilder("SS");

        }
        return -1;

    }
}
