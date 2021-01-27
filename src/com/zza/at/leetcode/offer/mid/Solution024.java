package com.zza.at.leetcode.offer.mid;

import java.util.HashMap;
import java.util.Map;

//最长不含重复字符的子字符串
public class Solution024 {
    //滑动窗口+HashMap
    public int lengthOfLongestSubstring(String s) {
        //使用哈希表map统计各字符最后一次出现的索引位置
        Map<Character, Integer> dic = new HashMap<>();
        // 左指针 i, 最大值 res
        int i = -1, res = 0;
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if(dic.containsKey(c))//如果存在当前字符c
                i = Math.max(i, dic.get(c)); // 更新左指针 i
            dic.put(c, j); // 哈希表记录
            res = Math.max(res, j - i); // 更新结果，j代表右指针
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
