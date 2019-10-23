// Leetcode 8
public class MyAtoi {
    public int myAtoi(String str){
        boolean isPositive = true;
        String validString = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){

            }else if(Character.isDigit(str.charAt(i)) || str.charAt(i) == '-' || str.charAt(i) == '+'){
                validString = str.substring(i);
                break;
            }else{
                return 0;
            }
        }
        if(validString.equals("")){
            return 0;
        }
        System.out.println(validString);
        if(validString.charAt(0) == '-'){
            isPositive = false;
            validString = validString.substring(1);
        }else if(validString.charAt(0) == '+'){
            validString = validString.substring(1);
        }
        StringBuilder tempFinalString = new StringBuilder();
        for(int i = 0; i < validString.length(); i++){
            if(Character.isDigit(validString.charAt(i))){
                tempFinalString.append(validString.charAt(i));
            }else{
                break;
            }
        }
        StringBuilder finalString = new StringBuilder();
        for(int i = 0; i < tempFinalString.length(); i++){
            if(tempFinalString.charAt(i) == '0'){

            }else{
                finalString = new StringBuilder(tempFinalString.substring(i));
                break;
            }
        }
        String upBound = "2147483647";
        String lowBound = "-2147483648";
        if(finalString.toString().equals("")){
            return 0;
        }else if(isPositive){
            if(finalString.length() < upBound.length() || (finalString.length() == upBound.length() && finalString.toString().compareTo(upBound) <= 0)){
                return Integer.valueOf(finalString.toString());
            }else{
                return Integer.valueOf(upBound);
            }

        }else{
            finalString.insert(0,'-');
            if(finalString.length() < lowBound.length() || (finalString.length() == lowBound.length() && finalString.toString().compareTo(lowBound) <= 0)){
                return Integer.valueOf(finalString.toString());
            }else{
                return Integer.valueOf(lowBound);
            }
        }
    }

}
