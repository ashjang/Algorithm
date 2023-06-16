package main;

/*
    풀이: 1(열)*n(행) 보드 판
 */

public class NQueen {
    static int n =4;
    static int[] board = new int[n];
    static int cnt;

    public static int nQueen(int row) {
        // 탈출조건 - 퀸을 다 둠
        if (row == n) {
            cnt++;
            // 출력
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }

        for (int i = 0; i < n; i++) {
            // 현재 행에 대해 몇 번째 열에다가 놓을 것인지
            board[row] = i;

            // promising
            if (isPromising(row)) {
                nQueen(row + 1);
            }
        }

        return cnt;
    }

    public static boolean isPromising(int row) {
        for (int i = 0; i < row; i++) {
            // 같은 열 안됨! 대각선 안됨!
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("경우의 수: " + nQueen(0));
    }
}