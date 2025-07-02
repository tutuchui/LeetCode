package classisc;

import java.util.ArrayList;
import java.util.List;

public class MaxTollRoad {
    public static int[]  maxTollRevenue(int num, int[][] roadList)
    {
        int[]  answer = new int[100];
        // Write your code here
        int roads = num - 1;
        List<List<Integer>> tree = new ArrayList<>();
        for(int i = 0; i <= num; i++) {
            tree.add(new ArrayList<>());
        }
        for(int[] edge : roadList) {
            int u = edge[0];
            int v = edge[1];
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        int[] size = new int[num + 1];
        int[] parent = new int[num + 1];
        int ca = 0;
        int cb = 0;
        int maxPath = - 1;
        dfs(1, -1, parent, size, tree);
        for(int[] edge: roadList) {
            int u = edge[0];
            int v = edge[1];
            int sz;
            if(parent[u] == v) {
                sz = size[v];
            }else{
                sz = size[u];
            }
            int pathCount = sz * (num - sz);
            if(pathCount > maxPath ||
                    (pathCount == maxPath && Math.min(u,v) < Math.min(ca,cb))
                    || (pathCount == maxPath && Math.min(u,v) == Math.min(ca,cb) && Math.max(u,v) < Math.max(ca,cb))){
                maxPath = pathCount;
                ca = u;
                cb = v;
            }
        }
        answer[0] = ca;
        answer[1] = cb;
        return answer;
    }

    private static int dfs(int node, int p, int[] parent, int[] size, List<List<Integer>> tree) {
        parent[node] = p;
        size[node] = 1;
        for(int neighbor : tree.get(node)) {
            if(neighbor != p) {
                size[node] += dfs(neighbor, node, parent, size, tree);
            }
        }

        return size[node];
    }
}
