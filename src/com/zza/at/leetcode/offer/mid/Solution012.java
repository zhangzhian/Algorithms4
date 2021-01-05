package com.zza.at.leetcode.offer.mid;

//构建乘积数组
public class Solution012 {
    public int[] constructArr(int[] a) {
        if(a == null || a.length == 0) return new int[0];
        int[] ret = new int[a.length];
        ret[0] = 1;
        int tmp = 1;
        for (int i = 1; i < a.length; i++) {
            ret[i] = ret[i-1] * a[i-1];
        }

        for (int i = a.length-2 ; i >= 0; i--){
            tmp *= a[i + 1];
            ret[i] *= tmp;
        }

        return ret;
    }

    public static void main(String[] args) {
        //[120,60,40,30,24]
        int[] ret = new Solution012().constructArr(new int[]{1,2,3,4,5});
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }
    }
}
