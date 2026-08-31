class Solution {
    public boolean validPalindrome(String s) {
        // Perform regular 2 pointer approach twice
        // when you find a mismatch
        // run the same logic for remaining part of s => s[left+1...right] || s[left...right - 1]
        // If all func calls returns false then its not a palindrome

        int left = 0;
        int right = s.length() - 1;
        return isPalindrome(s, left, right, 1);    
    }

    private boolean isPalindrome(String s, int left, int right, int delete) {
        while (left < right) {
            while (left < right && !isValidChar(s.charAt(left))) {
                left++;
            }

            while (left < right && !isValidChar(s.charAt(right))) {
                right--;
            }

            if (left >= right) break;

            char c1 = Character.toLowerCase(s.charAt(left));
            char c2 = Character.toLowerCase(s.charAt(right));

            if (c1 != c2) {
                if (delete == 0) { return false; }
                return isPalindrome(s, left + 1, right, delete - 1) || 
                       isPalindrome(s, left, right - 1, delete - 1);
            }

            left++;
            right--;
        }
        return true;
    }

    // private boolean isValidChar(char c) {
    //     return (c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122);
    // }

    private boolean isValidChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }
}