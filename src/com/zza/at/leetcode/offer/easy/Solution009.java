package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//二叉搜索树的第k大节点
public class Solution009 {

    //增序
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        dfs(list, root);
        return list.get(list.size() - k);
    }

    public void dfs(List list, TreeNode root) {
        if (root == null) return;
        //注意先左后右
        dfs(list, root.left);
        list.add(root.val);
        dfs(list, root.right);
    }

    //降序
    public int kthLargest1(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        dfs1(list, root);
        return list.get(k - 1);
    }

    public void dfs1(List list, TreeNode root) {
        if (root == null) return;
        //注意先右后左
        dfs1(list, root.right);
        list.add(root.val);
        dfs1(list, root.left);
    }

    //降序
    int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        dfs2(root);
        return res;
    }

    void dfs2(TreeNode root) {
        if (root == null || k == 0) return;//当root为空或者已经找到了res时，直接返回
        //注意先右后左
        dfs2(root.right);
        if (--k == 0) {
            res = root.val;
            return;
        }
        dfs2(root.left);
    }
}
