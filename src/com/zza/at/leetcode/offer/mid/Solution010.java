package com.zza.at.leetcode.offer.mid;

//股票的最大利润
public class Solution010 {
    public int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }


    public static void main(String[] args) {
        System.out.println(new Solution010().maxProfit(new int[]{7,1,5,3,6,4}));//5
    }
}
