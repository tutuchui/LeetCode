package NewOffer;

import java.util.LinkedList;

public class NewOffer13 {
    public void reOrderArray(int[] array){
        LinkedList<Integer> orderList = new LinkedList<>();
        int odd = 0;
        for(int temp : array){
            if(temp % 2 != 0){
                orderList.add(odd,temp);
                odd++;
            }else{
                orderList.addLast(temp);
            }
        }
        for(int i = 0; i < array.length;i++){
            array[i] = orderList.get(i);
        }
    }
}
