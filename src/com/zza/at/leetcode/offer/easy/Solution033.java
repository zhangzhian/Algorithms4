package com.zza.at.leetcode.offer.easy;

import java.util.HashSet;
import java.util.Set;

//扑克牌中的顺子
public class Solution033 {
    public boolean isStraight(int[] nums) {
        // 除大小王外，所有牌 无重复
        // 设此 5 张牌中最大的牌为 max，最小的牌为 min（大小王除外），则需满足：max−min<5
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if (num == 0) continue;
            max = Math.max(max,num);
            min = Math.min(min,num);
            if (repeat.contains(num)) return false;
            repeat.add(num);
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        System.out.println(new Solution033().isStraight(new int[]{1,2,3,4,5}));
    }
}
