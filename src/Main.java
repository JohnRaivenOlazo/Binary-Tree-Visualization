import java.util.Scanner;
import java.util.Stack;

class TreeNode {
    String val;
    int numericVal;
    TreeNode left;
    TreeNode right;

    TreeNode(String x) {
        val = x;
        numericVal = 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeapYear leapYear = new LeapYear();
        Fibonacci fibo = new Fibonacci();
        Diamond diamond = new Diamond();
        HeightComparison hcomp = new HeightComparison();

        System.out.println("1. Program that will create a menu and perform the operation for each option.");
        System.out.println("2. Program that takes, as input, a fully parenthesized, arithmetic expression and converts it to a binary expression tree.");
        System.out.println("MENU: ");
        int menu = scanner.nextInt();

        switch (menu) {
            case 1:
                System.out.print("Enter your name: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                System.out.println("Hello " + name + "\n\n");
                System.out.println("Tell me what you want to do. Here are your options:\n\n");
                System.out.println("[1] Determine if a year is a LEAP YEAR or NOT");
                System.out.println("[2] Height Comparison of 3 person");
                System.out.println("[3] Display a series");
                System.out.println("[4] Display a diamond of asterisk");
                System.out.print("Enter your choice: ");

                int options = scanner.nextInt();
                switch (options) {
                    case 1:
                        System.out.print("\n\nEnter a year: ");
                        int year = scanner.nextInt();
                        if (leapYear.isLeapYear(year)) {
                            System.out.println(year + " is a leap year");
                        } else {
                            System.out.println(year + " is not a leap year");
                        }
                        break;
                    case 2:
                        hcomp.compareHeight();
                        break;
                    case 3:
                        System.out.print("\n\nEnter n as limit: ");
                        int n = scanner.nextInt();
                        System.out.print("Series up to " + n + " terms:");
                        fibo.fibonacci(n);
                        break;
                    case 4:
                        diamond.printDiamond(scanner);
                        break;
                    default:
                        System.out.println("Option is invalid!");
                }
                break;
            case 2:
                System.out.println("You chose option 2. Enter the fully parenthesized arithmetic expression:");
                String expression = scanner.next();
                TreeNode root = constructExpressionTree(expression);
                displayTree(root);
                System.out.println("\nValue of root: " + evaluateExpressionTree(root, scanner));
                System.out.print("Prefix Notation: "); prefix(root);
                System.out.println();
                System.out.print("Postfix Notation: "); postfix(root);
                break;
            default:
                System.out.println("Menu is invalid!");
        }
    }


    public static TreeNode constructExpressionTree(String expression) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '(') {
                continue;
            } else if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == 'x')) {
                    num.append(expression.charAt(i++));
                }
                i--;
                stack.push(new TreeNode(num.toString()));
            } else if (Character.isLetter(c)) {
                stack.push(new TreeNode(Character.toString(c)));
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(new TreeNode(Character.toString(c)));
            } else if (c == ')') {
                TreeNode right = stack.pop();
                TreeNode operator = stack.pop();
                TreeNode left = stack.pop();
                operator.left = left;
                operator.right = right;
                stack.push(operator);
            }
        }
        return stack.peek();
    }


    public static void displayTree(TreeNode root) {
        printTree(root, "", true, true);
    }

    private static void printTree(TreeNode node, String indent, boolean isRight, boolean isRoot) {
        if (node != null) {
            if (node.right != null) {
                printTree(node.right, indent + (isRight ? "      " : "      "), true, false);
            }
            if (isRoot) {
            	System.out.println("("+node.val+")" + "---|");
            } else {
            	System.out.println(indent + (isRight ? " /" : " \\") + "---" + "("+node.val+")");
            }
            if (node.left != null) {
                printTree(node.left, indent + (isRight ? "      " : "      "), false, false);
            }
        }
    }


    public static int evaluateExpressionTree(TreeNode root, Scanner scanner) {
        if (root == null) {
            return 0;
        }
        if (Character.isDigit(root.val.charAt(0))) {
            return Integer.parseInt(root.val);
        } else if (Character.isLetter(root.val.charAt(0))) {
            System.out.print("Enter value for " + root.val + ": ");
            int val = scanner.nextInt();
            root.numericVal = val;
            return val;
        } else {
            int leftVal = evaluateExpressionTree(root.left, scanner);
            int rightVal = evaluateExpressionTree(root.right, scanner);
            switch (root.val) {
                case "+":
                    return leftVal + rightVal;
                case "-":
                    return leftVal - rightVal;
                case "*":
                    return leftVal * rightVal;
                case "/":
                    return leftVal / rightVal;
                default:
                    return 0;
            }
        }
    }
    
    public static void prefix(TreeNode root) {
        if (root != null) {
            System.out.print(root.val);
            prefix(root.left);
            prefix(root.right);
        }
    }

    public static void postfix(TreeNode root) {
        if (root != null) {
            postfix(root.left);
            postfix(root.right);
            System.out.print(root.val);
        }
    }
}
