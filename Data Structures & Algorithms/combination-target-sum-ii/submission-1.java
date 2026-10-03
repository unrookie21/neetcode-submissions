class Solution {

    public void dfs(List<List<Integer>> ans,
    List<Integer> cur, int start, int[] candidates, int target){

        int sum = 0;
        for (int i = 0; i < cur.size(); i++){
            sum += cur.get(i);
        }

        if (sum == target){
            ans.add(new ArrayList<>(cur));
            return;
        }

        if (sum > target) return;

        for (int i = start; i < candidates.length; i++){
            if (i > start && candidates[i] == candidates[i-1]){
                continue;
            }
            cur.add(candidates[i]);
            dfs(ans, cur, i + 1, candidates, target);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ans, new ArrayList<>(), 0, candidates, target);
        return ans;
    }
}
