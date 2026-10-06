class Solution {

    public int[] parent;

    public int find(int x){
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    boolean union(int a, int b){
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        parent[ra] = rb;
        return true;
    }

    
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent =new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                int cost = Math.abs(points[i][0] - points[j][0])
                + Math.abs(points[i][1] - points[j][1]);
                
                edges.add(new int[]{cost, i, j});
            }
        }

        edges.sort((a,b) -> a[0] - b[0]);

        int total = 0, count = 0;
        for (int[] e : edges){
            if (union(e[1], e[2])){
                total += e[0];
                if (++count == n -1 )break;
            }
        }
        return total;
    }
}
