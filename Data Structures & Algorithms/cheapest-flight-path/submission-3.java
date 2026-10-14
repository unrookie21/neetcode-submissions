
class Solution {

    static class Node implements Comparable<Node> {
        int node;
        int cost;
        int edges; // 큐 상태: 지금까지 탄 항공편 개수 (간선으로 쓸 때는 0, 사용 안 함)

        Node(int node, int cost, int edges) {
            this.node = node;
            this.cost = cost;
            this.edges = edges;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 그래프 초기화: 간선은 Node(도착지, 가격, 0)
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] f : flights) {
            graph.get(f[0]).add(new Node(f[1], f[2], 0));
        }

    
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0, 0));

        // [현재노드까지, 항공편의수(0~ k + 1로 올수 있는] 최소 비용 
        int[][] dist = new int[n][k+2];
        for (int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            
            if (cur.node == dst) return cur.cost;

            if (cur.edges > k) continue;

            if (cur.cost > dist[cur.node][cur.edges]) continue;

            for (Node next : graph.get(cur.node)){
                int newCost = cur.cost + next.cost;
                int newEdges = cur.edges + 1;

                if (newCost < dist[next.node][newEdges]){
                    dist[next.node][newEdges] = newCost;
                    pq.offer(new Node(next.node, newCost, newEdges));
                }
            }



        }

        

        

        return -1;
    }
}