package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

import java.util.LinkedList;

//对称的二叉树
public class Solution027 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return compare(root.left,root.right);
    }

    public boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return compare(left.left,right.right) && compare(left.right,right.left);
    }

    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return check(root.left,root.right);
    }

    public boolean check(TreeNode u, TreeNode v) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);//放2个root
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();//取2次
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);//u的left和v的right放进去，后续成对取出，作比较
            q.offer(v.right);

            q.offer(u.right);//同上
            q.offer(v.left);
        }
        return true;
    }
}
