class Solution {
    Map<String, Set<Character>> sudoku = new HashMap<>();
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for (int r=0; r<n; r++) {
            for (int c=0; c<m; c++) {
                char ch = board[r][c];
                if (ch == '.') { continue; }
                
                String row = "row" + String.valueOf(r);
                String col = "col" + String.valueOf(c);
                String box = "row" + String.valueOf(r/3) + "col" + String.valueOf(c/3);

                createIfNotPresent(row);
                createIfNotPresent(col);
                createIfNotPresent(box);

                if (sudoku.get(row).contains(ch) || sudoku.get(col).contains(ch) || sudoku.get(box).contains(ch)) {
                    return false;
                }
                
                add(ch, row);
                add(ch, col);
                add(ch, box);
            }
        }
        return true;
    }

    private void createIfNotPresent(String key) {
        if (!sudoku.containsKey(key)) {
            sudoku.put(key, new HashSet<>());
        }
    }

    private void add(char ch, String key) {
        sudoku.get(key).add(ch);
    }
}
