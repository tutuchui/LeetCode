package graduate;

import java.util.ArrayList;

public class RotateTheString {
    public String rotateTheString(String originalString, ArrayList<Integer> directions, ArrayList<Integer> amounts){
        String curStr = originalString;
        for(int i = 0; i < directions.size(); i++){
            int amount = amounts.get(i) % originalString.length();
            int dir = directions.get(i);
            for(int j = 0; j < amount; j++){
                curStr = moveString(curStr,dir);
            }
        }
        return curStr;
    }

    public String moveString(String originalString, int direction){
        if(direction == 0){
            char begin = originalString.charAt(0);
            String newString = originalString.substring(1);
            return newString + begin;
        }else{
            char end = originalString.charAt(originalString.length()-1);
            String newString = originalString.substring(0,originalString.length()-1);
            return end+newString;
        }
    }

    public static void main(String[] args) {
        RotateTheString rotateTheString = new RotateTheString();
        ArrayList<Integer> directions = new ArrayList<>();
        directions.add(0);
        directions.add(1);
        ArrayList<Integer> amounts = new ArrayList<>();
        amounts.add(4);
        amounts.add(1);
        System.out.println(rotateTheString.rotateTheString("hurart",directions,amounts));
    }
}
