package graduate;

//Leetcode 171
public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        String alphaBetaSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int totalLength = columnTitle.length();
        int result = 0;
        for(int i = 0; i < totalLength; i++){
            int curTimes = totalLength - i - 1;
            int curIndex = alphaBetaSet.indexOf(columnTitle.charAt(i)) + 1;
            result += Math.pow(26,curTimes) * curIndex;
        }
        return result;
    }

}
