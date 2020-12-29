package com.zza.at.leetcode.offer.mid;

//数组中数字出现的次数
public class Solution004 {
    public int[] singleNumbers(int[] nums) {
        //对所有数字进行一次异或，得到两个出现一次的数字的异或值
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        int div = 1;
        //在异或结果中找到任意为 1 的位
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            //根据这一位对所有的数字进行分组
            //两个只出现一次的数字在不同的组中
            //对两个组分别进行异或操作
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }


    public static void main(String[] args) {
        int[] ret = new Solution004().singleNumbers(new int[]{1,2,10,4,1,4,3,3});
        System.out.println(ret[0]+","+ret[1]);
    }
}
