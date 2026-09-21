class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        // 알파벳 소문자만 나오므로, 26개짜리 배열 선언.
        int[] count = new int[26];

        // s에서는 더하고, t에서는 뺀다음에, 최종적으로 0인지 확인
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count){
            if (val != 0) return false;
        }

        return true;


    }
}
