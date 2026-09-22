class Solution {
    public int[] twoSum(int[] nums, int target) {

        // return [i,j]
        // hashmap 사용한 풀이
        // target -nums[i] 가 hashmap 에 key 로 존재하면, target 이 완성 가능하다는 의미
        // 바로 return
        // 그렇지 않다면, hashmap 에 넣어놓고 다음 탐색 
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target -nums[i]) , i};
            }
            
            map.put(nums[i], i);
        }

        return null;

       
        
    }
}
