package com.zza.at.leetcode.hot100.mid;

import java.util.Arrays;

//任务调度器
public class Solution034 {
    public int leastInterval(char[] tasks, int n) {
        //题目限定 tasks[i] 是大写英文字母
        int[] buckets = new int[26];
        //统级出现次数，保存到数组
        for(int i = 0; i < tasks.length; i++){
            buckets[tasks[i] - 'A']++;
        }
        //排序
        Arrays.sort(buckets);
        //找出出现次数最多的
        int maxTimes = buckets[25];
        //一共有多少个任务和出现最多的那个任务出现次数一样
        int maxCount = 1;
        for(int i = 25; i >= 1; i--){
            if(buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        //完成所有任务需要的时间,见上面分析
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }


    public static void main(String[] args) {
        //tasks = ["A","A","A","B","B","B"], n = 2
        //输出：8
        int ret = new Solution034().leastInterval(new char[]{'A','A','A','B','B','B'},2);
        System.out.println(ret);
    }
}
