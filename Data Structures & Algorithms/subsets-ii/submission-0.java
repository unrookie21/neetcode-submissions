class Solution {


// nums : [3, 2, 3 , 1]

    public void dfs(List<List<Integer>> ans,
    List<Integer> cur, int start, int[] nums){

        ans.add(new ArrayList<>(cur));
        
        for (int i = start; i < nums.length; i++){
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            dfs(ans, cur, i + 1 , nums);
            cur.remove(cur.size() -1);
        }
    }




    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        dfs(ans, new ArrayList<>(), 0, nums);
        return ans;
    }
}
