import java.util.Stack;
import java.util.Vector;

public class GFG {
    public static boolean isBalanced(String s) {
       
        Stack<Character> st = new Stack<>();
       
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                
                // No opening bracket
                if (st.isEmpty()) return false; 
                char top = st.peek();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
                
                // Pop matching opening bracket
                st.pop(); 
            }
        }
        
        // Balanced if stack is empty
        return st.isEmpty(); 
    }

    public static void main(String[] args) {
        String s = "[()()]{}";
        System.out.println((isBalanced(s) ? "true" : "false"));
    }
}
