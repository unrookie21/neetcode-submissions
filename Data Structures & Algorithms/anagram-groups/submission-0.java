class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 애나그램끼리 묶어서 출력하기
        // sort 후 hashmap 생성
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());

        

        
    }
}
