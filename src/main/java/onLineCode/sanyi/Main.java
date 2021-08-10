package onLineCode.sanyi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：wenbo
 * @date ：Created in 2021/3/24 8:18 下午
 * @description：
 * @modified By：
 * @version: $
 */
public class Main {
    public static int MN(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(MN(3,7));
    }

    /**
     * 思路: 递归 + 回溯 + 剪枝
     */
    List<List<Integer>> path = new ArrayList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        if(dfs(obstacleGrid,0,0)){
            return path;
        }else{
            return new ArrayList<>();
        }
    }

    private boolean dfs(int[][] obstacleGrid, int row, int col){
        //当前路径不可走
        if (row > obstacleGrid.length-1 || col > obstacleGrid[0].length-1 || obstacleGrid[row][col] == 1){
            return false;
        }
        //当前坐标添加到路径中
        List<Integer> list = new ArrayList<>();
        list.add(row);
        list.add(col);
        path.add(list);

        if((row == obstacleGrid.length-1 && col == obstacleGrid[0].length-1) || dfs(obstacleGrid,row+1,col) || dfs(obstacleGrid,row,col+1)){
            return true;
        }
        //移除当前路径
        path.remove(path.size()-1);

        /** 如果到达此处, 说明从当前坐标(row,col)向下或向右移动都无法到达目标地, 那么将当前坐标置为1, 进行剪枝处理 */
        obstacleGrid[row][col] = 1;

        return false;
    }

}
