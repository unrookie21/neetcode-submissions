class Solution {
    public int search(int[] nums, int target) {
        // nums 에서 target 을 찾아, 그것의 index 반환
        
        int left = 0 , right = nums.length - 1;

        while (left <= right){

            int mid = (left + right) / 2;
            
            if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        
        return -1;
    }
}
