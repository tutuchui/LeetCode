package graduate;

//UnionSet
public class NumberOfProvince {

    public int findCircleNum(int[][] isConnected){
        int totalProvince = isConnected.length;
        int result = 0;
        //Make Set, initially, the parent node of each node is the node itself.
        int[] parent = new int[totalProvince];
        for(int i = 0; i < totalProvince; i++){
            parent[i] = i;
        }

        for(int i = 0; i < totalProvince; i++){
            for(int j = 0; j < totalProvince; j++){
                if(i != j && isConnected[i][j] == 1){
                    union(i,j,parent);
                }
            }
        }

        for(int i = 0; i < totalProvince; i++){
            if(parent[i] == i){
                result++;
            }
        }

        return result;
    }

    public int find(int[] parent, int index){
        if(index != parent[index]){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public void union(int i, int j, int[] parent){
        parent[find(parent, i)] = find(parent, j);
    }
}
