package com.zza.at.leetcode.hot100.mid;

//盛最多水的容器
public class Solution022 {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while(i < j){
            res = height[i] < height[j] ?
                    Math.max(res, (j - i) * height[i++]):
                    Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution022().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));//49
    }
}
