class Solution {

    public void dfs(String cur, List<String> ans, int curLeft, int curRight, int n){

        if (cur.length() == n * 2){
            ans.add(cur);
            return;
        }

        if (curLeft < n){
            dfs(cur + "(" , ans, curLeft + 1, curRight, n);
        }

        if (curRight < curLeft){
            dfs(cur + ")", ans, curLeft, curRight + 1, n);
        }

        
    }
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        
        dfs("(", ans, 1, 0, n);

        return ans;
        
    }
}
