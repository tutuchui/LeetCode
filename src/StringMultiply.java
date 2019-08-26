public class StringMultiply {
    public String multiply(String num1, String num2){
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int[] resultArray = new int[num1.length() + num2.length()];
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int a = Character.getNumericValue(num1.charAt(i));
                int b = Character.getNumericValue(num2.charAt(j));
                resultArray[i+j] += a * b;
                if(i + j != 0 && resultArray[i+j]>= 10){
                    resultArray[i+j-1] += resultArray[i+j] / 10;
                    resultArray[i+j]  = resultArray[i+j] % 10;
                }
            }
        }
        for(int i = 0; i < resultArray.length - 1; i++){
            result.append(resultArray[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        StringMultiply sm = new StringMultiply();
        System.out.println(sm.multiply("17","8"));

    }
}
