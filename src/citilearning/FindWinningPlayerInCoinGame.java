package citilearning;
//Leetcode 3222
public class FindWinningPlayerInCoinGame {
    public String losingPlayer(int x, int y) {
        int turn = 0;
        while (x > 0 && y > 3) {
           x = x - 1;
           y = y - 4;
           turn++;
        }

        if(turn % 2 == 1) {
            return "Alice";
        }else{
            return "Bob";
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindWinningPlayerInCoinGame().losingPlayer(4,11));
    }
}
