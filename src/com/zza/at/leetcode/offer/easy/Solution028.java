package com.zza.at.leetcode.offer.easy;

import java.util.Stack;

//包含min函数的栈
public class Solution028 {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */
    static class MinStack {
        Stack<Integer> A, B;
        /**
         * initialize your data structure here.
         */
        public MinStack() {
            A = new Stack<>();
            B = new Stack<>();
        }
        public void push(int x) {
            A.add(x);
            if(B.empty() || B.peek() >= x)
                B.add(x);
        }
        public void pop() {
            if(A.pop().equals(B.peek()))
                B.pop();
        }
        public int top() {
            return A.peek();
        }
        public int min() {
            return B.peek();
        }
    }

     class MinStack1 {
        //链表头，相当于栈顶
        private ListNode head;

        //压栈，需要判断栈是否为空
        public void push(int x) {
            if (empty())
                head = new ListNode(x, x, null);
            else
                head = new ListNode(x, Math.min(x, head.min), head);
        }

        //出栈，相当于把链表头删除
        public void pop() {
            if (empty())
                throw new IllegalStateException("栈为空……");
            head = head.next;
        }

        //栈顶的值也就是链表头的值
        public int top() {
            if (empty())
                throw new IllegalStateException("栈为空……");
            return head.val;
        }

        //链表中头结点保存的是整个链表最小的值，所以返回head.min也就是
        //相当于返回栈中最小的值
        public int min() {
            if (empty())
                throw new IllegalStateException("栈为空……");
            return head.min;
        }

        //判断栈是否为空
        private boolean empty() {
            return head == null;
        }
    }

    class ListNode {
        public int val;
        public int min;//最小值
        public ListNode next;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());  // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());   //   --> 返回 0.
        System.out.println(minStack.min());   //--> 返回 -2.

        MinStack1 minStack1 = new Solution028().new MinStack1();
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.push(-3);
        System.out.println(minStack1.min());  // --> 返回 -3.
        minStack1.pop();
        System.out.println(minStack1.top());   //   --> 返回 0.
        System.out.println(minStack1.min());   //--> 返回 -2.
    }


}
