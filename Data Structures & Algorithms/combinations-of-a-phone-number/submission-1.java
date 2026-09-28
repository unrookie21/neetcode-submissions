class Solution {

    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.isEmpty()) return res;
        backtracking(0, "", digits);
        return res;
    }   
    // digits "34"
    // cur == d , i == 1
    private void backtracking(int i , String cur, String digits){

        if (cur.length() == digits.length()){
            res.add(cur); // dg, dh, di 
            return;
        }
        // def - ghi 
        String chars = digitToChar[digits.charAt(i) - '0'];

        // d
        for (char c : chars.toCharArray()){
            backtracking(i + 1, cur + c, digits);
        }
        
    }
}
