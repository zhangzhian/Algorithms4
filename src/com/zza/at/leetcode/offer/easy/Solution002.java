package com.zza.at.leetcode.offer.easy;

import com.zza.at.leetcode.common.TreeNode;

import java.util.LinkedList;

//二叉树的镜像
public class Solution002 {
    //递归-从下到上
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = mirrorTree1(root.left);
        TreeNode right = mirrorTree1(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    //递归-从上到下
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        mirrorTree2(root.left);
        mirrorTree2(root.right);
        return root;
    }

    //BFS
    public TreeNode mirrorTree3(TreeNode root) {
        if(root==null) {
            return null;
        }
        //将二叉树中的节点逐层放入队列中，再迭代处理队列中的元素
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            //每次都从队列中拿一个节点，并交换这个节点的左右子树
            TreeNode tmp = queue.poll();
            TreeNode left = tmp.left;
            tmp.left = tmp.right;
            tmp.right = left;
            //如果当前节点的左子树不为空，则放入队列等待后续处理
            if(tmp.left!=null) {
                queue.add(tmp.left);
            }
            //如果当前节点的右子树不为空，则放入队列等待后续处理
            if(tmp.right!=null) {
                queue.add(tmp.right);
            }

        }
        //返回处理完的根节点
        return root;
    }

    //2021.03.11
    public TreeNode mirrorTree4(TreeNode root){
        if (root == null) return null;
        TreeNode left = mirrorTree4(root.right);
        TreeNode right = mirrorTree4(root.left);

        root.left = right;
        root.right = left;

        return root;
    }

}
