class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

         char[] result = s.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();

        int left = 0, right = result.length - 1;

        while (right > left) {
            if (result[left] != result[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
        
    }
}
