import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLine()) {
            String inputString = scanner.nextLine();
            System.out.println(sortString(inputString));
        }
    }

    public static String sortString(String word){
        HashMap<Integer,Character> symbolMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
       for(int i = 0; i < word.length();i++){
           if(Character.isAlphabetic(word.charAt(i))){
               sb.append(word.charAt(i));

           }else{
               symbolMap.put(i,word.charAt(i));
           }
       }
//        System.out.println(sb.toString());
       for(int i = sb.length() - 1; i > 0; i--){
           for(int j = 0; j < i; j++){
               if(Character.toLowerCase(sb.charAt(j)) > Character.toLowerCase(sb.charAt(j+1))){
                   char temp = sb.charAt(j);
                   sb.setCharAt(j,sb.charAt(j+1));
                   sb.setCharAt(j+1,temp);
               }
           }
       }
//       System.out.println(sb.toString());
       ArrayList<Integer> indexlist = new ArrayList<>();
       for(int index : symbolMap.keySet()){
           indexlist.add(index);
       }
       Collections.sort(indexlist);
       for(int index : indexlist){
           sb.insert(index,symbolMap.get(index));
       }
       return sb.toString();
    }

}