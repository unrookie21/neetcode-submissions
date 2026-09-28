class Solution {
    public List<String> letterCombinations(String digits) {
        // 34
        // def , ghi

        List<String> ans = new ArrayList<>();

        String[] digitToChar = {
            "", "", "abc", "def",
            "ghi", "jkl",  "mno",
            "pqrs", "tuv", "wxyz"
        };

        if (digits.isEmpty()) return new ArrayList<>();

        ans.add("");

        for (char digit : digits.toCharArray()){
            List<String> tmp = new ArrayList<>();
            
            for (String curStr : ans){
                for (char c : digitToChar[digit - '0'].toCharArray()){
                    tmp.add(curStr + c);
                }


            }

            ans = tmp;
        }
        
        return ans;

    }
}
