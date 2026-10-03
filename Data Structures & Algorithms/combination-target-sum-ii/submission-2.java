class Solution {

    public void dfs(List<List<Integer>> ans,
    List<Integer> cur, int start, int[] candidates, int target
    , int sum){

        if (sum == target){
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target) return;

        for (int i = start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            if (sum + candidates[i] > target) break;
            cur.add(candidates[i]);
            dfs(ans, cur, i + 1, candidates, target, sum + candidates[i]);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), 0, candidates, target, 0);
        return ans;
    }
}
