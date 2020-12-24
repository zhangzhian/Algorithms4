package com.zza.at.leetcode.offer.easy;

//和为s的两个数字
public class Solution019 {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length -1;
        int sum = 0;
        while(i < j) {
            sum = nums[i] + nums[j];
            if (sum > target) j--;
            if (sum < target) i++;
            if (sum == target) return new int[]{nums[i],nums[j]};
        }
        return new int[0];
    }
}
