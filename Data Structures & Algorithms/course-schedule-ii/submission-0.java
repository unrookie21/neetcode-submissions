class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] ans = new int[numCourses];
        // [a,b] 의 의미 : b를 먼저 들어야 a 들을 수 있다.

        // course 번호는 0번부터 n -1 까지.

        // 모든 코스의 순서 반환 

        // graph 초기화
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        // indegree 가 0 인 과목들을 큐에 한번에 넣고 시작하자.
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }

        int idx = 0;
        while (!q.isEmpty()){
            int cur = q.poll();
            ans[idx++] = cur;
            
            for (int next : graph.get(cur)){
                indegree[next]--;
                if (indegree[next] == 0){
                    q.offer(next);
               
                }
            }
        }

        return idx == numCourses ? ans : new int[0];
        
    }
}
