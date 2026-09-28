class Solution {

    public void dfs(List<List<Integer>> ans, List<Integer> cur,
    int[] nums, int target, int start, int sum){

        if (sum > target) return;

        if (sum == target){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            int tmp = 0;
            for (int j = 0 ; j < cur.size(); j++){
                tmp += cur.get(j);
            }
            dfs(ans, cur, nums, target, i, tmp);
            cur.remove(cur.size() - 1);
        }

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(ans, new ArrayList<>(), nums, target, 0, 0);

        return ans;
    }
}
