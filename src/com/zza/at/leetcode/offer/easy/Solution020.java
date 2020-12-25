package com.zza.at.leetcode.offer.easy;

//调整数组顺序使奇数位于偶数前面
public class Solution020 {
    public int[] exchange(int[] nums) {
       int i = 0; //偶数指针
       int j = nums.length-1;//奇数指针
       int temp = 0;
       while (i<j){
           while (i < j &&(nums[i] & 0x1) == 1) i++;
           while (i < j &&(nums[j] & 0x1) == 0) j--;
           temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
       }
       return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        int[] ret = new Solution020().exchange(nums);
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
}
