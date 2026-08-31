class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < right && !isValidChar(s.charAt(left))) {
                left++;
            }

            while (left < right && !isValidChar(s.charAt(right))) {
                right--;
            }

            char c1 = Character.toLowerCase(s.charAt(left));
            char c2 = Character.toLowerCase(s.charAt(right));

            if (c1 != c2) { return false; }
            
            left++;
            right--;
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    }
}
