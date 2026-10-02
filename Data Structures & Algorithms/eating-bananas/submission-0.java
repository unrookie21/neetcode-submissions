class Solution {

    public boolean canEat(int[] piles, int k, int h){

        long hours = 0;
        for (int p : piles){
            hours += (p + k - 1) / k;
        }

        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        for (int p : piles){
            right = Math.max(right, p);
        }

        while (left < right){
            int mid = (left + right) / 2;
            
            if (canEat(piles, mid, h)){
                right = mid;
            } else {
                left = mid + 1;
            }


        }

        return left;

       
        
    }
}
