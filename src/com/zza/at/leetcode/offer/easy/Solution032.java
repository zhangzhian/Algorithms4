package com.zza.at.leetcode.offer.easy;

//旋转数组的最小数字
public class Solution032 {
    public int minArray(int[] numbers) {
        int i = 0;
        int j =numbers.length-1;
        int mid;
        while (i < j){
            mid = (i + j) / 2;
            if (numbers[mid] > numbers[j]) i = mid +1;
            else if (numbers[mid] < numbers[j])  j = mid;
            else j--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        System.out.println(new Solution032().minArray(new int[]{3,4,5,1,2}));
        System.out.println(new Solution032().minArray(new int[]{1,3,5}));
        System.out.println(new Solution032().minArray(new int[]{2,2,2,0,1}));
    }
}
