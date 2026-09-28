class Solution {

    public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums,
    boolean[] visited){

        if (cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                dfs(ans, cur, nums, visited);
                cur.remove(cur.size() - 1);
                visited[i] = false;
            }
        }



    }
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();

        // 순열
        boolean[] visited = new boolean[nums.length];

        dfs(ans, new ArrayList<>(), nums, visited);

        return ans;
        
    }
}
