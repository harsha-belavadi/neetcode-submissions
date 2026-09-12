class Solution {
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    private boolean validPalindrome(String s, int left, int right, int deleted) {
        if (left >= right) {
            return true;
        }

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
                if (deleted == 0) {
                    return validPalindrome(s, left + 1, right, 1) 
                    || validPalindrome(s, left, right - 1, 1);
                }
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