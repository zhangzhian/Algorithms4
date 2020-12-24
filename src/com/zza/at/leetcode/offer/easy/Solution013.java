package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

//二叉树的最近公共祖先 注意015
public class Solution013 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left == null) return right;//左子树没查到，在右子树
        if (right == null) return left;//右子树没查到，在左子树
        return root;//分别在左右子树中
    }
}
