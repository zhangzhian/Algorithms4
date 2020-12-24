package com.zza.at.leetcode.offer.easy;

//二进制中1的个数
public class Solution011 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while (n!=0){
            ret++;
            n = n&(n-1);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution011().hammingWeight(0b0000000010000000010000000001011));
    }

}
