package com.zza.at.leetcode.offer.easy;

//数组中出现次数超过一半的数字
public class Solution017 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) candidate = nums[i];
            if (nums[i] == candidate){
                count++;
            }else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,2,5,4,2};
        System.out.println(new Solution017().majorityElement(nums));
    }
}
