package leetcode.Num130;

/**
 * 130. Surrounded Regions
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * <p>
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * <p>
 * Example:
 * <p>
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * <p>
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * Explanation:
 * <p>
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 * <p>
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class Solution {
    int X_MAX;
    int Y_MAX;
    char[][] board;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        this.board = board;
        X_MAX = board.length;
        Y_MAX = board[0].length;
        for (int x = 0; x < X_MAX; x++) {
            for (int y = 0; y < Y_MAX; y++) {
                if(!DFT(x, y)){
                    DFTset(x,y,'o');
                }
            }
        }
        for (int x = 0; x < X_MAX; x++) {
            for (int y = 0; y < Y_MAX; y++) {
                if(board[x][y]=='o'){
                    board[x][y]='O';
                }else if(board[x][y]=='S'){
                    board[x][y]='X';
                }
            }
        }
    }

    private void DFTset(int x, int y, char c) {
        if(x<0||x>=X_MAX||y<0||y>=Y_MAX){
            return;
        }
        if(board[x][y]=='S'){
            board[x][y]=c;
            int[][] offsetArray={
                    {0,1},
                    {0,-1},
                    {1,0},
                    {-1,0}
            };
            for(int[] offset:offsetArray){
                DFTset(x+offset[0],y+offset[1],c);
            }
        }


    }
    /**
     * 深度优先遍历
     *
     * @return true 若当前点不为O 或四面皆不为O
     * false 超出边界
     * else 将当前点设置为S 对周围的点进行DFT 若返回值均为true 则返回true 否则返回false
     */
    private boolean DFT(int x, int y) {
        // 超出边界 返回false
        if(x<0||x>=X_MAX||y<0||y>=Y_MAX){
            return false;
        }
        // 当前点不为O 返回true
        if(board[x][y]!='O'){
            return true;
        }
        // 将当前点设为S
        board[x][y]='S';
        // 遍历四周的点
        int[][] offsetArray={
                {0,1},
                {0,-1},
                {1,0},
                {-1,0}
        };
        boolean flag=true;
        for(int[] offset:offsetArray){
            if(!DFT(x+offset[0],y+offset[1])){
                flag=false;
            }
        }
        return flag;
    }
}
