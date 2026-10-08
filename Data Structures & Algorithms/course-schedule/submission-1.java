class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] edge : prerequisites){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        // 시작점 초기화
        Queue<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0){
                q.offer(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()){

            count++;
            int cur = q.poll();
            for (int next : graph.get(cur)){

                indegree[next]--;
                if(indegree[next] == 0) q.offer(next);
            }
        }

        return count == numCourses;

        
        
    }
}
