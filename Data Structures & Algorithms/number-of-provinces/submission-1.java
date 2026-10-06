class Solution {

    public int[] parent;

    public int find(int x){
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int a, int b){
        int ra = find(a) , rb = find(b);
        if (ra == rb) return false;
        parent[ra] = rb;
        return true;
    }
    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        parent = new int[n];

        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
      
        int ans = n;

        // 처음 묶음은 n개 이므로, n 개에서 시작해서 
        // 모든 연결관계들을 순회하며, union 을 확인

        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                if (isConnected[i][j] == 1 && union(i,j)){
                    ans--;
                }
            }
        }

        return ans;
        
    }
}