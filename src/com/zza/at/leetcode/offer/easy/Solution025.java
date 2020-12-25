package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

//平衡二叉树
public class Solution025 {

    //从顶至底
    //空间复杂度高NlogN
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = getNodeNum(root.left);
        int r = getNodeNum(root.right);
        if (Math.abs(l-r) > 1) return false;
        return isBalanced(root.left) & isBalanced(root.right);
    }

    public int getNodeNum(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getNodeNum(root.left),getNodeNum(root.right)) + 1;
    }


    //从底至顶
    public boolean isBalanced1(TreeNode root){
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
