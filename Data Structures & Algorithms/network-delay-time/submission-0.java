class Solution {

    public class Node implements Comparable<Node>{

        public int node;
        public int cost;

        public Node(int n, int c){
            this.node = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Node other){
            return this.cost - other.cost;
        }

    }

    public void dijkstra(List<List<Node>> graph,
    int[] dist, int n , int start){

        Arrays.fill(dist, Integer.MAX_VALUE);
        // 시작점 처리
        dist[start] = 0;
        
        // 최소힙 
        Queue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()){
           
            Node cur = pq.poll();

            if (cur.cost > dist[cur.node]) continue;

            for (Node next : graph.get(cur.node)){
                int newCost = cur.cost + next.cost;

                if (newCost < dist[next.node]){
                    dist[next.node] = newCost;
                    pq.offer(new Node(next.node, newCost));
                }


            }
            
        }

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // n개의 모든 노드가 신호를 받기까지 걸리는 최소 시간
        // 모든 노드가 신호를 받는게 불가능하면 -1 반환.

        // 다익스트라로 dist 배열 초기화하고, 그 값중 최댓값 구하면 되나?

        // [0, 0, 1, 2, 3]
        
        // graph 초기화
        List<List<Node>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for (int[] edge : times){
            int a = edge[0];
            int b = edge[1];
            int c = edge[2];

            graph.get(a).add(new Node(b, c)); // diredcted graph
        }

        int[] dist = new int[n+1];
        dijkstra(graph, dist, n , k);

        int min = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++){
            if (dist[i] == Integer.MAX_VALUE){
                return -1;
            } else {
                min = Math.max(min, dist[i]);
            }
            
        }

        return min;
    }
}
