class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 애나그램끼리 묶어서 출력하기
        // count 배열을 활용한 풀이 
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            
            int[] count = new int[26];
            for (char c : str.toCharArray()){
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
           
        }

        return new ArrayList<>(map.values());
    }
}
