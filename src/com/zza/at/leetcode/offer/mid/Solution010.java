package com.zza.at.leetcode.offer.mid;

import java.util.Stack;

//栈的压入、弹出序列
public class Solution010 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        int[] tmpe = new int[pushed.length];
        for (int i = 0, j = 0; i < pushed.length; i++, index++) {
            tmpe[index] = pushed[i];//模拟入栈
            while (index >= 0 && j < popped.length && tmpe[index] == popped[j]) {// 循环判断与模拟出栈
                j++;
                index--;
            }
        }
        return index == 0;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //pushed = [1,2,3,4,5], popped = [4,5,3,2,1] 输出：true
        //pushed = [1,2,3,4,5], popped = [4,3,5,1,2] 输出：false
        int[] test1 = {1,2,3,4,5};
        int[] test2 = {4,5,3,2,1};
        int[] test3 = {4,3,5,1,2};
        System.out.println(new Solution010().validateStackSequences(test1,test2));
        System.out.println(new Solution010().validateStackSequences(test1,test3));
        System.out.println(new Solution010().validateStackSequences1(test1,test2));
        System.out.println(new Solution010().validateStackSequences1(test1,test3));
    }
}
