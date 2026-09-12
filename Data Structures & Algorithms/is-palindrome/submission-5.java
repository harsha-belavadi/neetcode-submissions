class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (!isValidChar(s.charAt(left))) {
                left++;
                continue;
            } 

            if (!isValidChar(s.charAt(right))) {
                right--;
                continue;
            }

            char c1 = Character.toUpperCase(s.charAt(left));
            char c2 = Character.toUpperCase(s.charAt(right));
            if (c1 != c2) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}
