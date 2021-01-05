package com.zza.at.leetcode.hot100.mid;

//颜色分类
public class Solution030 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        //从左向右遍历整个数组
        //如果找到了 0，那么就需要将 0 与「头部」位置的元素进行交换
        //并将「头部」向后扩充一个位置
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        //从「头部」开始，从左向右遍历整个数组
        //如果找到了 1，那么就需要将 1 与「头部」位置的元素进行交换
        //并将「头部」向后扩充一个位置
        for (int i = ptr; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        //指针 p0来交换0，p1来交换1，初始值都为0。
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            //找到了1，那么将其与nums[p1] 进行交换，并将 p1向后移动一个位置
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                //找到了0,将其与 nums[p0] 进行交换
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                //当 p0 < p1 时
                //再将nums[i] 与nums[p1] 进行交换
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                //p0和p1均向后移动一个位置
                ++p0;
                ++p1;
            }
        }
    }
}
