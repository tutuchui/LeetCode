//Leetcode 13
public class RomanToInt {
    public int romanToInt(String s) {
        char[] sChar = s.toCharArray();
        int result = 0;
        int i = 0;
        while(i < sChar.length){
            if(sChar[i] == 'I'){
                if(i + 1 < sChar.length&&sChar[i+1] == 'V'){
                    result += 4;
                    i += 2;
                }
                else if(i + 1 < sChar.length&&sChar[i+1] == 'X'){
                    result += 9;
                    i += 2;
                }
                else{
                    result += 1;
                    i += 1;
                }
            }
        if(sChar[i] == 'X'){
            if(i + 1 < sChar.length && sChar[i+1] == 'L'){
                result += 40;
                i += 2;
            }
            else if(i + 1 < sChar.length&&sChar[i+1] == 'C'){
                result += 90;
                i += 2;
            }
            else{
                result += 10;
                i += 1;
            }
        }
        if(sChar[i] == 'C'){
            if(i + 1 < sChar.length&&sChar[i+1] == 'D'){
                result += 400;
                i += 2;
            }
            else if(i + 1 < sChar.length&&sChar[i+1] == 'M'){
                result += 900;
                i += 2;
            }
            else{
                result += 100;
                i += 1;
            }
        }
        if(sChar[i] == 'V'){
            result += 5;
            i++;
        }
        if(sChar[i] == 'L'){
            result += 50;
            i++;
        }
        if(sChar[i] == 'D'){
            result += 500;
            i++;
        }
        if(sChar[i] == 'M'){
            result += 1000;
            i++;
        }
    }
        return  result;
    }
}
