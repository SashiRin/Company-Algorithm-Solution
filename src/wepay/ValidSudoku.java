package wepay;

/**
 * Project Name : Company Algorithm Solution
 * Package Name : wepay
 * File Name : ValidSudoku
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ValidSudoku {
    //hashset可以优化
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!isValid(board, i, j)) return false;
            }
        }
        return true;
    }
    private boolean isValid(char[][] board, int i, int j) {
        for (int row = 0; row < 9; row++) {
            if (row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        for (int col = 0; col < 9; col++) {
            if (col == j) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if (row == i && col == j) continue;
                if (board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
}
