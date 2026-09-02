class Solution {
    Map<String, Set<Character>> map = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length; 

        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                char ch = board[r][c];
                if (ch == '.') { continue; }

                String row = "row" + r;
                String col = "col" + c;
                String rc = "row" + r/3 + "col" + c/3;

                generateKey(row);
                generateKey(col);
                generateKey(rc);

                if (map.get(row).contains(ch) ||
                    map.get(col).contains(ch) ||
                    map.get(rc).contains(ch)) {
                    return false;
                }

                map.get(row).add(ch);
                map.get(col).add(ch);
                map.get(rc).add(ch);
            }
        }
        return true;
    }

    private void generateKey(String key) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<>());
        }
    }
}
