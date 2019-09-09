import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.valueOf(scanner.nextLine());
        if (N == 1){
            System.out.println(1);
            return;
        }
        int[] array = new int[N-1];
        String arrayInput = scanner.nextLine();
        for(int i = 0; i < N - 1; i++){
            array[i] = Integer.valueOf(arrayInput.split(" ")[i]);
        }
        System.out.println((int)(solvePer(array) % (Math.pow(10,9) + 7)));

    }

    public static int solvePer(int[] array) {
        int n = array.length + 1;
        List<Integer> result = new ArrayList<>();
        Set<Integer> avaliableList = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            avaliableList.add(i);
        }
        Iterator<Integer> iterator = avaliableList.iterator();
        for (int i = 1; i <= n; i++) {
            permutation(result, iterator.next(), avaliableList, array,0);
        }
        return result.size();
    }

    public static void permutation(List<Integer> result, int selectedNumber, Set<Integer> avaliableList, int[] array,int currentIndex) {
        avaliableList = new HashSet<>(avaliableList);
        avaliableList.remove(selectedNumber);
        if (avaliableList.size() == 0) {
            result.add(0);
            return;
        }
        HashSet<Integer> nextAvailableList = new HashSet<>();
        boolean isGreater;
        if(array[currentIndex] == 0){
            isGreater = true;
        }else{
            isGreater = false;
        }
        if(isGreater){
            for(int cur : avaliableList){
                if(cur > selectedNumber){
                    nextAvailableList.add(cur);
                }
            }
        }else{
            for(int cur : avaliableList){
                if(cur < selectedNumber){
                    nextAvailableList.add(cur);
                }
            }
        }
            if(nextAvailableList.size() == 0){
            return;
        }

        for (int num : nextAvailableList) {
            permutation(result, num, avaliableList, array, currentIndex+1);
        }
        }
    }

