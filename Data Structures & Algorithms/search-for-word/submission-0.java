class Solution {
    private char[][] board;
    private int length;
    private String word;
    private Set<String> visited;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        this.visited = new HashSet<>();
        int r = 0;
        int c = 0;

        for (r=0; r<board.length; r++) {
            for (c=0; c<board[0].length; c++) {
                if (backtrack(r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int r, int c, int idx) {
        if (idx == word.length()) { return true; }

        String key = r + ", " + c;
        if (r < 0 || r == board.length || c < 0 || c == board[0].length || board[r][c] != word.charAt(idx) || visited.contains(key)) {
            return false;
        }

        visited.add(key);
        boolean result = backtrack(r + 1, c, idx + 1) || backtrack(r, c + 1, idx + 1) || backtrack(r - 1, c, idx + 1) || backtrack(r, c - 1, idx + 1);
        visited.remove(key);
        return result;
    }
}
