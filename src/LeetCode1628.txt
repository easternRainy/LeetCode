/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class NumberNode extends Node {
    private int num;

    public NumberNode(int num) {
        this.num = num;
    }

    public int evaluate() {
        return this.num;
    }
}


class ExpressionNode extends Node {
    private char exp;
    public Node left;
    public Node right;

    public ExpressionNode(char exp) {
        if(exp=='+' || exp=='-' || exp=='*' || exp=='/') {
            this.exp = exp;
        } else {
            throw new IllegalArgumentException();
        }

    }


    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return this.right;
    }

    public int evaluate() {

        int leftVal = this.left.evaluate();
        int rightVal = this.right.evaluate();

        if (this.exp == '+') {
            return leftVal + rightVal;
        }

        if (this.exp == '-') {
            return leftVal - rightVal;
        }

        if (this.exp == '*') {
            return leftVal * rightVal;
        }

        if (this.exp == '/') {
            return leftVal / rightVal;
        }

        return -100001;
    }
}


/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<postfix.length; i++) {
            String curr = postfix[i];
            System.out.println(curr + isExp(curr));
            if(isExp(curr)) {
                ExpressionNode expNode = new ExpressionNode(curr.charAt(0));
                Node right = stack.pop();
                Node left = stack.pop();
                expNode.setLeft(left);
                expNode.setRight(right);
                stack.push(expNode);
            } else {

                Node numNode = new NumberNode(Integer.parseInt(curr));
                stack.push(numNode);
            }
        }

        return stack.pop();
    }


    public static boolean isExp(String str) {
        char ch = str.charAt(0);
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        } else {
            return false;
        }
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */