class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> rowMap = new HashMap<>();
        Map<String, Set<Character>> colMap = new HashMap<>();
        Map<String, Set<Character>> rcMap = new HashMap<>();

        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[0].length; c++) {
                char ch = board[r][c];
                
                if (ch == '.') { continue; }
                
                String rowKey = "row" + r;
                String colKey = "col" + c;
                String rcKey = "row" + (r / 3) + "col" + (c / 3);
                
                generateKey(rowKey, rowMap);
                generateKey(colKey, colMap);
                generateKey(rcKey, rcMap);

                if (rowMap.get(rowKey).contains(ch) || colMap.get(colKey).contains(ch) || rcMap.get(rcKey).contains(ch)) {
                    return false;
                }

                rowMap.get(rowKey).add(ch);
                colMap.get(colKey).add(ch);
                rcMap.get(rcKey).add(ch);
            }
        }
        return true;
    }

    private void generateKey(String key, Map<String, Set<Character>> map) {
        if (!map.containsKey(key)) {
            map.put(key, new HashSet<>());
        }
    }
}
