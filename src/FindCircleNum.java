public class FindCircleNum {
    class UnionFind{
        int count;
        int[] parent;
        int[] rank;

        UnionFind(int n){
            this.count = n;
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int getCount(){
            return this.count;
        }

        int find(int p){
            while(p!=parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        void union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);
            if(pRoot == qRoot){
                return;
            }
            if(rank[pRoot] > rank[qRoot]){
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }else if(rank[qRoot] > rank[pRoot]){
                parent[pRoot] = qRoot;
                rank[qRoot]++;
            }else{
                parent[qRoot] = pRoot;
                rank[pRoot]++;
            }
            count--;
        }
    }
    public int findCircleNum(int[][] M) {
        int peopleNum = M.length;
        int result = 0;
        if(peopleNum == 0){
            return 0;
        }
        UnionFind unionFind = new UnionFind(peopleNum);
        for(int i = 0; i < peopleNum; i++){
            for(int j = 0; j < i ; j++){
                if(M[i][j] == 1){
                    unionFind.union(i,j);
                }

            }
        }

        return unionFind.getCount();

    }
}
