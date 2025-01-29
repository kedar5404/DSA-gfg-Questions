import java.util.*;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string of brackets:");
        String input = scanner.nextLine();
        if (isBalanced(input)) {
            System.out.println("The brackets are balanced.");
        } else {
            System.out.println("The brackets are not balanced.");
        }
        scanner.close();
    }

    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                default:
                    // If the character is not a bracket, ignore it or handle as needed
                    break;
            }
        }
        return stack.isEmpty();
    }
}
