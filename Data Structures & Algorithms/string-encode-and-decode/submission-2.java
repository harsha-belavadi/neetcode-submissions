class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length());
            sb.append("#");
            sb.append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        int i=0;
        while (i < str.length()) {
            StringBuilder len = new StringBuilder();
            while (str.charAt(i) != '#') {
                len.append(str.charAt(i));
                i++;
            }
            Integer length = Integer.parseInt(len.toString());
            i++;
            String substring = str.substring(i, i + length);
            strs.add(substring);
            i += length;
        }
        return strs;
    }
}
