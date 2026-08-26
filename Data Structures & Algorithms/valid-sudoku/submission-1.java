class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> rowset = new HashMap<>();
        Map<String, Set<Character>> colset = new HashMap<>();
        Map<String, Set<Character>> squareset = new HashMap<>();

        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                char ch = board[r][c];
                
                if (ch == '.')  { continue; }
                
                String row = "r" + r;
                String col = "c" + c;
                String rc = "r" + r/3 + "c" + c/3;

                generateKey(rowset, row);
                generateKey(colset, col);
                generateKey(squareset, rc);

                if (rowset.get(row).contains(ch) || 
                        colset.get(col).contains(ch) ||
                        squareset.get(rc).contains(ch)) {
                    return false;
                }

                rowset.get(row).add(ch);
                colset.get(col).add(ch);
                squareset.get(rc).add(ch);
            }
        }

        return true;
    }

    private void generateKey(Map<String, Set<Character>> map, String key) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<>());
        }
    }
}
