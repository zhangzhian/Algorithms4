package com.zza.at.leetcode.offer.easy;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//第一个只出现一次的字符
public class Solution023 {
    //有序哈希表
    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (Map.Entry<Character, Boolean> d : dic.entrySet()) {
            if (d.getValue()) return d.getKey();
        }
        return ' ';
    }

    //哈希表
    public char firstUniqChar1(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        for (char c : sc)
            dic.put(c, !dic.containsKey(c));
        for (char c : sc)
            if (dic.get(c)) return c;
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Solution023().firstUniqChar("abaccdeff"));
    }
}
