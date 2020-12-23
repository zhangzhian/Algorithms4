package com.zza.at.leetcode.offer.easy;

//打印从1到最大的n位数
public class Solution005 {

    //直接计算，未考虑大输
    public int[] printNumbers0(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 0; i < end; i++)
            res[i] = i + 1;

        return res;
    }


    //计算大数
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }

    void dfs(int x) {
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!s.equals("0")) res[count++] = Integer.parseInt(s);
            if (n - start == nine) start--;
            return;
        }
        for (char i : loop) {
            if (i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }

    //字符表示法
    public static class Solution {
        StringBuilder res;
        int nine = 0, count = 0, start, n;
        char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        public String printNumbers(int n) {
            this.n = n;
            res = new StringBuilder();			// 数字字符串集
            num = new char[n];					// 定义长度为 n 的字符列表
            start = n - 1;						// 非0左边界 start
            dfs(0);							// 开启全排列递归
            res.deleteCharAt(res.length() - 1);	// 删除最后多余的逗号
            return res.toString();				// 转化为字符串并返回
        }
        void dfs(int x) {
            if(x == n) {						// 终止条件：已固定完所有位
                String s = String.valueOf(num).substring(start);
                // 拼接 num 并添加至 res 尾部，使用逗号隔开
                if(!s.equals("0")) res.append(s + ",");
                if(n - start == nine) start--;  // 所有位都为 9
                return;
            }
            for(char i : loop) {				// 遍历 ‘0‘ - ’9‘
                if(i == '9') nine++;			// 数字各位中 9 的数量为 nine
                num[x] = i;						// 固定第 x 位为 i
                dfs(x + 1);						// 开启固定第 x + 1 位
            }
            nine--;								// 回溯前恢复
        }
    }

    public static void main(String[] args) {
        int[] ret = new Solution005().printNumbers(4);
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < ret.length -1; i++) {
            builder.append(ret[i] + ",");
        }
        builder.append(ret[ret.length-1] + "]");
        System.out.println(builder.toString());
        System.out.println(new Solution().printNumbers(4));
    }
}
