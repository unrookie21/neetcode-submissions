class Solution {

    public class Node implements Comparable<Node>{

        int node;
        int cost;
        int edges;

        public Node(int n , int c, int e){
            this.node = n;
            this.cost = c;
            this.edges = e;
        }

        @Override
        public int compareTo(Node other){
            return Integer.compare(cost, other.cost);
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Node>> graph = new ArrayList<>();

        // k 범위는 0부터 k + 1 (항공편의 개수는 경유지 수 + 1)
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for (int[] edge : flights){
            graph.get(edge[0]).add(new Node(edge[1], edge[2], 0));
        }

        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(src, 0, 0));
        dist[src][0] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();

            if (cur.node == dst) return cur.cost;
            
            if (cur.cost > dist[cur.node][cur.edges]) continue;
            
            if (cur.edges > k) continue;

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
