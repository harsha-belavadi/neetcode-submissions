class Solution {
    public boolean isPalindrome(String s) {
        int l=0, r=s.length() - 1;
        while (l < r) {
            if (!isAlphanumeric(s.charAt(l))) { l++; continue; }
            if (!isAlphanumeric(s.charAt(r))) { r--; continue; }
            
            char left = Character.toLowerCase(s.charAt(l));
            char right = Character.toLowerCase(s.charAt(r));

            if (left != right) { return false; }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return (c != ' ' && ((c >=48 && c <= 57) || (c >= 65 && c <= 90)) || (c >= 97 && c <= 122));
    }
}
