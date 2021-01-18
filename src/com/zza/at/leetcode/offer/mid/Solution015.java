package com.zza.at.leetcode.offer.mid;

import java.util.Arrays;
import java.util.Comparator;

//把数组排成最小的数
public class Solution015 {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution015().minNumber(new int[]{3,30,34,5,9}));
    }
}
