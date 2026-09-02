class Solution {
    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length()-1, 1);
    }

    private boolean isPalindrome(String s, int left, int right, int delete) {
        while (left < right) {
            while (left < right && !isValidChar(s.charAt(left))) {
                left++;
            }

            while(left < right && !isValidChar(s.charAt(right))) {
                right--;
            }

            char c1 = Character.toUpperCase(s.charAt(left));
            char c2 = Character.toUpperCase(s.charAt(right));

            if (c1 != c2) {
                if (delete == 0) { return false; }
                return isPalindrome(s, left+1, right, delete-1) ||
                       isPalindrome(s, left, right-1, delete-1);
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isValidChar(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}