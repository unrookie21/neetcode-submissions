class Solution {

    public void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums,
    int start){

        ans.add(new ArrayList<>(cur));
        
        // dfs
        for (int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            dfs(ans, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }


    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(ans, new ArrayList<>(), nums, 0);

        return ans;
        
    }
}
