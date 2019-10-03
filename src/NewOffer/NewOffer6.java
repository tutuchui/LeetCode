package NewOffer;

public class NewOffer6 {
    public int minNumberInRotateArray(int [] array) {
        int left = 0;
        int right = array.length -1;
        if(array.length == 1){
            return array[0];
        }
        int result = -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(array[mid] > array[mid + 1]){
                result = array[mid + 1];
            }
            if(array[mid] < array[0]){
               right = mid;
            }else{
                left = mid + 1;
            }
        }
        return result;
    }
}
