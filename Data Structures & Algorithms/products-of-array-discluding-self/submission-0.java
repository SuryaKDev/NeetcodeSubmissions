class Solution {
    public int[] productExceptSelf(int[] nums) {

        int prefix = 1, suffix = 1;

        int[] prefixArr = new int[nums.length];
        int[] suffixArr = new int[nums.length];        

        for (int i = 0; i < nums.length; i++) {
            prefixArr[i] = prefix;
            prefix = nums[i] * prefix;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            suffixArr[i] = suffix;
            suffix = nums[i] * suffix;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = prefixArr[i] * suffixArr[i];
        }

        return nums;

    }
}  
