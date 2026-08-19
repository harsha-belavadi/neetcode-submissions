class Solution {
    private String s;
    private List<String> partition;
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        this.s = s;
        partition = new ArrayList<>();
        result = new ArrayList<>();
        backtrack(0);
        return result;
    }

    private void backtrack(int i) {
        if (i == s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int j=i; j<s.length(); j++) {
            if (isPalindrome(i, j)) {
                partition.add(s.substring(i, j + 1));
                backtrack(j+1);
                partition.removeLast();
            }
        }
    }

    private boolean isPalindrome(int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) { 
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
