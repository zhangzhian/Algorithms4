package com.zza.at.leetcode.offer.mid;

//二维数组中的查找
public class Solution026 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length)//左下角元素
        {
            //消去第 i 行元素
            if(matrix[i][j] > target) i--;
            //消去第 j 列元素
            else if(matrix[i][j] < target) j++;
            //找到目标值
            else return true;
        }
        return false;
    }
}
