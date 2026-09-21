class Solution {
    public boolean hasDuplicate(int[] nums) {

        // hashing

        Set<Integer> hashSet = new HashSet<>();

        for (int n : nums){
            if (hashSet.contains(n)) return true;
            hashSet.add(n);
        }

        return false;

    }
}