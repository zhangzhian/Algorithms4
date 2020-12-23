package com.zza.at.leetcode.offer.easy;
//[001] 左旋转字符串
public class Solution001 {

    //字符串切片
    public String reverseLeftWords1(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    //列表遍历拼接
    public String reverseLeftWords2(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length()+n; i++) {
            builder.append(s.charAt(i%s.length()));
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution001().reverseLeftWords1("abcdefg",2));
        System.out.println(new Solution001().reverseLeftWords2("abcdefg",2));
    }
}
