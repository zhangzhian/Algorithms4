package com.zza.at.leetcode.hot100.mid;

import java.util.Deque;
import java.util.LinkedList;

//每日温度
public class Solution018 {
    public int[] dailyTemperatures(int[] T) {
        int[] ret = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            for (int j = i +1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }

    //优化
    public int[] dailyTemperatures1(int[] T) {
        int[] result = new int[T.length];
        //从右向左遍历
        for (int i = T.length - 2; i >= 0; i--) {
            // j+= result[j]是利用已经有的结果进行跳跃
            for (int j = i + 1; j < T.length; j+= result[j]) {
                if (T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) { //遇到0表示后面不会有更大的值，那当然当前值就应该也为0
                    result[i] = 0;
                    break;
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures3(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ret = new Solution018().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int i : ret) {
            System.out.println(i);
        }//1, 1, 4, 2, 1, 1, 0, 0
    }
}
