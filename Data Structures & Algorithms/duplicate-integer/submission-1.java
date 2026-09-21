class Solution {
    public boolean hasDuplicate(int[] nums) {

        // 3, 4, 1, 2 , 2

        // 1, 2, 2, 3, 4
        
        Arrays.sort(nums);
        
        for (int i = 1; i < nums.length; i++){

            if (nums[i] == nums[i-1]){
                return true;
            }

        }

        return false;

    }
}