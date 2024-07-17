// Time Complexity : O(n)
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, had to learn

/*
 * Problem# :227. Basic Calculator II
 * 
 * Things to note: if character is not digit or i is the last index.
 * (+) -> push currNum to stack
 * (-)  -> push currNum * -1 to stack
 * (*) -> push currNum*stack.pop()
 * (/)-> push currNum*stack.pop()
 * 
 * We are processing only based on the previous or lastSign not the currentSign. one step behind
 * Every time we hit a sign we set currNum to zero.
 */

import java.util.*;

public class BasicCalculatorII {
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || (i == s.length() - 1)) {
                if (lastSign == '+') {
                    stack.push(currNum);
                } else if (lastSign == '-') {
                    stack.push(-currNum);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / currNum);
                }
                currNum = 0;
                lastSign = c;
            }

        }

        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
}
