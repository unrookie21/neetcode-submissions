class Solution {
    public boolean hasDuplicate(int[] nums) {

        boolean answer = false;
        

        for (int i = 0; i < nums.length; i++){

            int cur = nums[i];
            for (int j = i+1; j < nums.length; j++){
                int next = nums[j];
                if (cur == next){
                    answer = true;
                    break;
                }
            }

            if (answer) break;
        }

        return answer;
        
    }
}