package com.zza.at.leetcode.offer.mid;

// 求1+2+…+n
// 不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
public class Solution001 {

    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution001().sumNums(100));
    }
}
