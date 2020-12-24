package com.zza.at.leetcode.offer.easy;

import java.util.ArrayList;
import java.util.List;

//和为s的连续正数序列
public class Solution014 {
    public int[][] findContinuousSequence(int target){
        int i = 1; // 滑动窗口的左边界
        int j = 1; // 滑动窗口的右边界
        int sum = 0; // 滑动窗口中数字的和
        List<int[]> res = new ArrayList<>();

        while (i <= target / 2) {//i>target/2,再加上一个比它大的数，必然不符合条件
            if (sum < target) {
                // 右边界向右移动
                sum += j;
                j++;
            } else if (sum > target) {
                // 左边界向右移动
                sum -= i;
                i++;
            } else {
                // 记录结果
                int[] arr = new int[j-i];
                for (int k = i; k < j; k++) {
                    arr[k-i] = k;
                }
                res.add(arr);
                // 右边界向右移动
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        int[][] ret = new Solution014().findContinuousSequence(15);
        System.out.println(ret.toString());
    }
}
