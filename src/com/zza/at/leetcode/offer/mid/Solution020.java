package com.zza.at.leetcode.offer.mid;


public class Solution020 {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    boolean recur(int[] postorder, int i, int j) {
        if(i >= j-1) return true;//任意两个数都可以构成搜索树的后序遍历
        int p = i;
        while(postorder[p] < postorder[j]) p++;
        int m = p;
        while(postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution020().verifyPostorder(new int[]{1,6,3,2,5}));//f
        System.out.println(new Solution020().verifyPostorder(new int[]{1,3,2,6,5}));//t
    }
}
