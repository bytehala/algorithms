package leetcode.problem36;

class Solution {

    public boolean isValidHorizontal(char[][] board, int x, int y) {
        char value = board[y][x];
        for(int i = 0; i < board[0].length; i++) {
            if (i != x && board[y][i] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidVertical(char[][] board, int x, int y) {
        char value = board[y][x];
        for(int i = 0; i < board.length; i++) {
            if (i != y && board[i][x] == value) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidSquare(char[][] board, int x, int y) {
        char value = board[y][x];

        // Gets the top left corner of the 3x3 square:
        int xSquareStart = (x / 3) * 3;
        int ySquareStart = (y / 3) * 3;

        for(int yAdd = 0; yAdd < 3; yAdd++)
            for (int xAdd = 0; xAdd < 3; xAdd++) {
                int currentX = xSquareStart + xAdd;
                int currentY = ySquareStart + yAdd;
                if (currentY != y && currentX != x &&
                        board[currentY][currentX] == value) {
                    return false;
                }
            }

        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board.length; x++) {
                if (board[y][x] != '.' && (!isValidHorizontal(board, x, y) ||
                        !isValidVertical(board, x, y) ||
                        !isValidSquare(board, x, y))
                ) {
                    return false;
                }
            }
        }
        return true;
    }
}

public class Problem36 {

    public static void main(String[] args) {
        Solution s = new Solution();
        // Call method below:
        System.out.println(s.isValidSudoku(new char[][]{
          {'5','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','9','8','.','.','.','.','6','.'},
          {'8','.','.','.','6','.','.','.','3'},
          {'4','.','.','8','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','.','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        }));

    }
}
