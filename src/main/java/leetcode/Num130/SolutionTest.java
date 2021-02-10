package leetcode.Num130;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private void diyAssert(char[][] result, char[][] output) {
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[0].length; j++) {
                assertEquals(result[i][j], output[i][j]);
            }
        }
    }

    private void print(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

    @Test
    public void test1() {
        Solution s = new Solution();
        char[][] input = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        char[][] result = {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
        };
        print(input);
        System.out.println("");
        s.solve(input);
        print(input);

        diyAssert(input, result);
    }

    @Test
    public void test2() {
        Solution s = new Solution();
        char[][] input = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        char[][] result = {
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
        };
        print(input);
        System.out.println("");
        s.solve(input);
        print(input);

        diyAssert(input, result);
    }

    @Test
    public void test3() {
        Solution s = new Solution();
        char[][] input = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'},
        };
        char[][] result = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'},
        };
        print(input);
        System.out.println("");
        s.solve(input);
        print(input);

        diyAssert(input, result);
    }

    @Test
    public void test4() {
        Solution s = new Solution();
        char[][] input = {
                {'X','O','X','O','X','O','O','O','X','O'},
                {'X','O','O','X','X','X','O','O','O','X'},
                {'O','O','O','O','O','O','O','O','X','X'},
                {'O','O','O','O','O','O','X','O','O','X'},
                {'O','O','X','X','O','X','X','O','O','O'},
                {'X','O','O','X','X','X','O','X','X','O'},
                {'X','O','X','O','O','X','X','O','X','O'},
                {'X','X','O','X','X','O','X','O','O','X'},
                {'O','O','O','O','X','O','X','O','X','O'},
                {'X','X','O','X','X','X','X','O','O','O'}
        };
        char[][] result = {
                {'X','O','X','O','X','O','O','O','X','O'},
                {'X','O','O','X','X','X','O','O','O','X'},
                {'O','O','O','O','O','O','O','O','X','X'},
                {'O','O','O','O','O','O','X','O','O','X'},
                {'O','O','X','X','O','X','X','O','O','O'},
                {'X','O','O','X','X','X','X','X','X','O'},
                {'X','O','X','X','X','X','X','O','X','O'},
                {'X','X','O','X','X','X','X','O','O','X'},
                {'O','O','O','O','X','X','X','O','X','O'},
                {'X','X','O','X','X','X','X','O','O','O'}
        };
        print(input);
        System.out.println("");
        s.solve(input);
        print(input);

        System.out.println("");
        print(result);


        diyAssert(input, result);
    }
}