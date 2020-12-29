package com.zza.at.leetcode.offer.mid;

import java.util.HashMap;
import java.util.Map;

//数组中数字出现的次数 II
public class Solution002 {
    // 使用 HashMap 记录各个数字出现的次数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = nums.length - 1; i >= 0; --i){
            int key = nums[i];
            if(!map.containsKey(key)){
                // 如果之前没有遇到这一数字，则放入 map 中
                map.put(key, 1);
            }else{
                // 如果之前遇到过这一数字，则出现次数加 1
                map.put(key, map.get(key) + 1);

            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }

    public int singleNumber1(int[] nums) {
        int[] counts = new int[32];//建立一个长度为 32 的数组，通过以上方法可记录所有数字的各二进制位的1的出现次数。
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;//更新第 j 位
                num >>>= 1;//第 j 位 --> 第 j + 1 位
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;// 得到 只出现一次的数字 的第 (31 - i) 位
        }
        return res;
    }

}
