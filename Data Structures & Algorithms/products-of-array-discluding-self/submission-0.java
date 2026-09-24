class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] output = new int[nums.length];
        // output[i]는 nums[i] 제외하고, 왼쪽 곱 x 오른쪽 곱 
        int prefix = 1;
        for (int i = 0; i < nums.length; i++){
            output[i] = prefix;
            prefix = prefix * nums[i];
        }
        // output : [1, 1, 2, 8] 왼쪽 곱만 반영된 상태

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--){
            output[i] *= suffix;
            suffix *= nums[i];
        }
        return output;
    }
}  
