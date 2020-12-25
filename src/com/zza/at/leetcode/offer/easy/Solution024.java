package com.zza.at.leetcode.offer.easy;

//连续子数组的最大和
public class Solution024 {
    public int maxSubArray(int[] nums) {
        //dp:以nums[i]为结尾的连续子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public int maxSubArray1(int[] nums) {
        int pre = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre= Math.max(pre + nums[i],nums[i]);
            maxSum = Math.max(maxSum, pre);
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(new Solution024().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
