package graduate;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length;i++){
            if(safe(graph,color,i)){
                result.add(i);
            }
        }
        return result;
    }

    public boolean safe(int[][] graph, int[] color, int curNode){
        if(color[curNode] > 0){
            return color[curNode] == 2;
        }

        color[curNode] = 1;
        for(int i = 0; i < graph[curNode].length; i++){
            if(!safe(graph, color, graph[curNode][i])){
                return false;
            }
        }
        color[curNode] = 2;
        return true;
    }

}
