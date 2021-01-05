package com.zza.at.leetcode.offer.mid;

import com.zza.at.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

//二叉树中和为某一值的路径
public class Solution014 {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return res;
    }

    public void dfs(TreeNode root, int tar) {
        if (root == null) return;
        path.add(root.val);
        tar -= root.val;
        if (tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        dfs(root.left, tar);
        dfs(root.right, tar);
        //向上回溯前，需要将当前节点从路径 path 中删除
        path.removeLast();
    }

}
