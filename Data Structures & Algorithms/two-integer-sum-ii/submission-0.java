class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int n = numbers.length;
        int lt = 0, rt = n - 1;

        while (lt < rt){

            int sum = numbers[lt] + numbers[rt];

            if (sum == target){
                return new int[]{lt + 1, rt + 1};
            } else if (sum > target){
                rt--;
            } else {
                lt++;
            }

        }
    
         // 두 수의 합이 target 이 되는 두수의 인덱스를 return
        return new int[]{-1,-1};
    }
}
