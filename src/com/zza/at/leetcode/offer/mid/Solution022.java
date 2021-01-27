package com.zza.at.leetcode.offer.mid;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//维护一个单调的双端队列
public class Solution022 {
    class MaxQueue {

        Queue<Integer> q;//辅助队列来记录所有被插入的值
        Deque<Integer> d;//双端队列记录最大的值

        public MaxQueue() {
            q = new LinkedList<Integer>();
            d = new LinkedList<Integer>();
        }

        public int max_value() {
            if (d.isEmpty()) {
                return -1;
            }
            return d.peekFirst();
        }

        public void push_back(int value) {
            //从队列尾部依次取出比当前元素 value 小的元素
            while (!d.isEmpty() && d.peekLast() < value) {
                d.pollLast();
            }
            d.offerLast(value);
            q.offer(value);
        }

        public int pop_front() {
            if (q.isEmpty()) {
                return -1;
            }
            int ans = q.poll();
            if (ans == d.peekFirst()) {
                d.pollFirst();
            }
            return ans;
        }
    }
}
