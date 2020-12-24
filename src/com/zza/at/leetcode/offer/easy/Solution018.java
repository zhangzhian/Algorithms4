package com.zza.at.leetcode.offer.easy;

import java.util.HashSet;
import java.util.Set;

//数组中重复的数字
public class Solution018 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (set.contains(num)) return num;
            set.add(num);
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums){
        int temp;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]!=i){
                //索引 与 索引对应的值 相等， 该数字已经存在了
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Solution018().findRepeatNumber1(nums));
    }
}
