import java.util.HashSet;
import java.util.LinkedList;

public class NumSquare {
    private class Node{
        int val;
        int step;

        public Node(int val, int step){
            this.val = val;
            this.step = step;
        }
    }

    public int numSquares(int n) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(new Node(n,0));
        HashSet<Integer> visitedNode = new HashSet<>();
        while(!queue.isEmpty()){
            Node cur = queue.removeFirst();
            int curVal = cur.val;
            int step = cur.step;
            for(int i = 1; ;i++){
                int a = curVal - i * i;
                if(a < 0){
                    break;
                }
                if( a == 0){
                    return step + 1;
                }
                if(!visitedNode.contains(a)){
                    queue.addLast(new Node(a,step + 1));
                    visitedNode.add(a);
                }
            }
        }
        return -1;
    }

}
