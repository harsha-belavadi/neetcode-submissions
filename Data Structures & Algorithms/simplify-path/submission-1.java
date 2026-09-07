class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        for (String dir : components) {
            // Skip empty parts (from consecutive slashes) or current directory "."
            if (dir.isBlank() || dir.equals(".")) { continue; }
            
            // ".." means move up one directory (pop if stack isn't empty)
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // It's a valid directory name, push it to the stack
                stack.push(dir);
            }
        }

        // Reconstruct the path from the stack elements
        StringBuilder output = new StringBuilder();
        while(!stack.isEmpty()) {
            output.insert(0, "/" + stack.pop());
        }
        
        // If the stack was empty, we are at the root "/"
        return output.isEmpty() ? "/" : output.toString();
    }
}