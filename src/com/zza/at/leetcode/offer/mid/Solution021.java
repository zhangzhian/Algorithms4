package com.zza.at.leetcode.offer.mid;

import java.util.LinkedList;
import java.util.Queue;

//机器人的运动范围
public class Solution021 {
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        // 向右和向下的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        //记录是否已经访问
        boolean[][] vis = new boolean[m][n];
        //队列中放入
        queue.offer(new int[]{0, 0});
        //置true，表示已经访问
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            //向右和向下check
            for (int i = 0; i < 2; ++i) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                //越界/访问过/大于k
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;
                }
                //放入队列
                queue.offer(new int[]{tx, ty});
                //置已经访问过
                vis[tx][ty] = true;
                ans++;
            }
        }
        return ans;
    }

    //递推
    public int movingCount0(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        //记录是否可达
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                //不符合
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 可达性判断
                // 搜索方向只需朝下或朝右，因此 (i, j) 的格子只会从 (i - 1, j) 或者 (i, j - 1) 两个格子走过来
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }


    int m, n, k;
    boolean[][] visited;
    public int movingCountDFS(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, get(i+1), sj)
                + dfs(i, j + 1, si, get(j+1));
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        //输入：m = 2, n = 3, k = 1
        //输出：3
        System.out.println(new Solution021().movingCount(2,3,1));
        System.out.println(new Solution021().movingCountDFS(2,3,1));
    }
}
