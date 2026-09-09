class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String dir : components) {
            if (dir.isBlank() || dir.equals(".")) {
                continue;
            }

            if (dir.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                continue;
            }

            stack.push(dir);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.pop());
        }

        return result.isEmpty() ? "/" : result.toString();
    }
}