package com.zza.at.leetcode.offer.easy;

//替换空格
public class Solution006 {

    public String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                builder.append("%20");
            }else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution006().replaceSpace("We are happy."));
    }
}
