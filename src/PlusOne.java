public class PlusOne {
    public int[] plusOne(int[] digits) {
        StringBuilder sb = new StringBuilder();
        for(int temp : digits){
            sb.append(String.valueOf(temp));
        }
        Long num = Long.valueOf(sb.toString());
        num = num + 1;
        StringBuilder result = new StringBuilder(String.valueOf(num));
        int[] res = new int[result.length()];
        for(int i = 0; i < result.length(); i++){
            res[i] = Character.getNumericValue(result.charAt(i));
        }

        return res;
    }
}
