package com.zza.at.leetcode.hot100.mid;

import java.util.Arrays;
import java.util.PriorityQueue;

//数组中的第K个最大元素
public class Solution023 {
    //暴力
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    //堆
    public int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最小堆，默认是最小堆，可以不写 lambda 表达式：(a, b) -> a - b
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a - b);
        for (int i = 0; i < len; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < len - k; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public int findKthLargest2(int[] nums, int k) {
        int len = nums.length;
        // 使用一个含有 len 个元素的最大堆，lambda 表达式应写成：(a, b) -> b - a
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> b - a);
        for (int i = 0; i < len; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = 0; i < k -1 ; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Solution023().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));//4
        System.out.println(new Solution023().findKthLargest1(new int[]{3,2,3,1,2,4,5,5,6},4));//4
        System.out.println(new Solution023().findKthLargest2(new int[]{3,2,3,1,2,4,5,5,6},4));//4
    }
}
