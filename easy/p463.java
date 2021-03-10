package leetcode.easy;

public class p463 {
    public static void main(String[] args) {
        System.out.println(islandPerimeter(new int[][]{
                {1, 1, 1},
                {1, 1, 0}
        }));
    }

    public static int islandPerimeter(int[][] grid) {
        //重点关注前面遍历过得方格，如果之前有相邻方格，就-2;
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rsp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rsp += 4;
                    if (i > 0 && grid[i - 1][j] == 1) {
                        rsp -= 2;
                    }
                    if (j > 0 && grid[i][j - 1] == 1) {
                        rsp -= 2;
                    }
                }
            }
        }
        return rsp;
    }
}

/*
 public int islandPerimeter(int[][] grid) {
        // 举例推导出公式 res = 4 * 岛屿格子数量 - 2 * 岛屿格子之间的相邻边
        int m = 0, n= 0;
        if(grid == null || (m = grid.length) == 0 || (n = grid[0].length) == 0) return 0;

        int count = 0; // 岛屿格子数量
        int edge = 0; // 岛屿格子之间的相邻边
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0) continue;
                count++;

                if(j+1 < n && grid[i][j+1] == 1)    edge++; // 判断右边是不是 陆地格子

                if(i+1 < m && grid[i+1][j] == 1)    edge++; // 判断下面是不是 陆地格子
            }
        }

        return 4 * count - 2 * edge;
    }
 */

/*
给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。

网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。

岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

 

示例 :

输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

输出: 16

解释: 它的周长是下面图片中的 16 个黄色的边：

 */