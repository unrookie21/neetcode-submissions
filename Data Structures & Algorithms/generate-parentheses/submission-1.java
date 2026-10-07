class Solution {

    public void dfs(StringBuilder cur, List<String> ans, int curLeft, int curRight, int n){

        if (cur.length() == n * 2){
            ans.add(cur.toString());
            return;
        }

        if (curLeft < n){
            cur.append('(');
            dfs(cur , ans, curLeft + 1, curRight, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (curRight < curLeft){
            cur.append(')');
            dfs(cur, ans, curLeft, curRight + 1, n);
            cur.deleteCharAt(cur.length() - 1);
        }

        
    }
    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();
        
        dfs(new StringBuilder(), ans, 0, 0, n);

        return ans;
        
    }
}
