class Solution {
    private char[][] board;
    private String word;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                if (backtrack(r, c, 0)) { return true; }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r == board.length || c < 0 || c == board[0].length 
        || board[r][c] != word.charAt(idx) || board[r][c] == '#') {
            return false;
        }

        char tmp = board[r][c];
        board[r][c] = '#';
        boolean result = backtrack(r+1, c, idx+1) || backtrack(r-1, c, idx+1) 
                        || backtrack(r, c+1, idx+1) || backtrack(r, c-1, idx+1);
        board[r][c] = tmp;
        return result;
    }
}
