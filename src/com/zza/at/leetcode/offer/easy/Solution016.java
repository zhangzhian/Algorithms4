package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//从上到下打印二叉树 II
public class Solution016 {

    //bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while (queue.size() != 0){
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            while (size != 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)queue.offer(node.left);
                if (node.right != null)queue.offer(node.right);
                size--;
            }
            ret.add(list);
        }
        return ret;
    }

    private List<List<Integer>> ret;
    public List<List<Integer>> levelOrder1(TreeNode root){
        ret = new ArrayList<>();
        dfs(0, root);
        return ret;
    }

    //需要带上depth，根据depth确定保存的位置
    private void dfs(int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        //每次depth第一次进入添加一个空list，供后续添加数据
        if (ret.size() == depth) {
            ret.add(new ArrayList<>());
        }
        ret.get(depth).add(root.val);
        dfs(depth + 1, root.left);
        dfs(depth + 1, root.right);
    }
    public static void main(String[] args) {

    }
}
