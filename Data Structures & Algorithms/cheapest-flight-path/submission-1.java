
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

        // minEdges[노드]: 그 노드를 확장한 상태 중 가장 적은 항공편 수
        int[] minEdges = new int[n];
        Arrays.fill(minEdges, Integer.MAX_VALUE);

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(src, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 비용 오름차순이므로 처음 꺼낸 dst가 최저가
            if (cur.node == dst) return cur.cost;

            // 이미 항공편 수가 같거나 적은 상태가 처리됐다면 스킵
            if (minEdges[cur.node] <= cur.edges) continue;
            minEdges[cur.node] = cur.edges;

            // 항공편을 이미 k+1개 탔으면 더 확장 불가
            if (cur.edges > k) continue;

            for (Node next : graph.get(cur.node)) {
                // 간선 객체를 그대로 넣지 않고, 누적 비용과 항공편 수로 새 Node를 만들어 넣는다
                pq.offer(new Node(next.node, cur.cost + next.cost, cur.edges + 1));
            }
        }

        return -1;
    }
}