import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExamRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        int n = Integer.valueOf(firstLine.split(" ")[0]);
        int m = Integer.valueOf(firstLine.split(" ")[1]);
        int[][] friend = new int[m][2];
        ArrayList<Integer> removeList = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0; i < m;i++) {
            String tmpLine = scanner.nextLine();
            friend[i][0] = Integer.valueOf(tmpLine.split(" ")[0]);
            friend[i][1] = Integer.valueOf(tmpLine.split(" ")[1]);
            if (hashMap.containsKey(friend[i][0])) {
                hashMap.put(friend[i][0], hashMap.get(friend[i][0]) + 1);
            } else {
                hashMap.put(friend[i][0], 1);
            }
            if (hashMap.containsKey(friend[i][1])) {
                hashMap.put(friend[i][1], hashMap.get(friend[i][1]) + 1);
            } else {
                hashMap.put(friend[i][1], 1);
            }
        }
        ExamRoom examRoom = new ExamRoom();
        if(!examRoom.removeAll(friend)){
            int mostIndex = examRoom.findMostFriend(hashMap);
            removeList.add(mostIndex);
            examRoom.removeFriend(friend,mostIndex);
            examRoom.updateMap(friend,hashMap);
        }
        System.out.println(removeList.size());
        System.out.println(removeList);

    }

    public int findMostFriend(HashMap<Integer,Integer> hashMap){
        int mostValue = -1;
        int mostKey = -1;
        for(int key : hashMap.keySet()){
            if(hashMap.get(key) > mostValue){
                mostValue = hashMap.get(key);
                mostKey = key;
            }
        }

        return mostKey;
    }

    public void removeFriend(int[][] friend, int index){
        for(int i = 0; i < friend.length;i++){
            if(friend[i][0] == index || friend[i][1] == index){
                friend[i][0] = -1;
                friend[i][1] = -1;
            }
        }
    }

    public boolean removeAll(int[][] friend){

        for(int i = 0; i < friend.length;i++){
            if(friend[i][0] != -1 ){
                return false;
            }
        }
        return true;
    }

    public HashMap<Integer,Integer> updateMap(int[][] friend, HashMap<Integer,Integer> hashMap){
        hashMap.clear();
        for(int i = 0; i < friend.length;i++) {
            if (hashMap.containsKey(friend[i][0])) {
                hashMap.put(friend[i][0], hashMap.get(friend[i][0]) + 1);
            } else {
                hashMap.put(friend[i][0], 1);
            }
            if (hashMap.containsKey(friend[i][1])) {
                hashMap.put(friend[i][1], hashMap.get(friend[i][1]) + 1);
            } else {
                hashMap.put(friend[i][1], 1);
            }
        }
        return hashMap;
    }
}
