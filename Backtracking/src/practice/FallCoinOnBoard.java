package practice;

/*
    Practice4
    2차원 배열 board 존재. 'o','#','.'의 정보가 담겨 있는데,
        o: 동전
        #: 벽
        .: 빈칸
    동전은 항상 두개가 있고 두 동전이 함께 이동하다가 하나가 보드에서 떨어지는 경우의 최소 이동 횟수를 출력
    이동 규칙
        1. 동전은 좌,우,위,아래로 이동 가능하고 같은 방향으로 함께 이동
        2. 빈칸이나 동전이 있는 칸으로 이동 가능
        3. 벽일 때 이동 불가능
        4. 이동 횟수가 10번을 넘으면 중지하고 -1 반환

    ex)
    board: {{'.','#'}, {'.','#'}, {'.','#'}, {'o','#'}, {'o','#'}, {'#','#'}}
    output: 4
 */

import java.util.ArrayList;

/*
    가능풀이
    - dfs과 유사
        - 두 동전이 함께 떨어지는 것 차단
        - 벽으로 막힌 것 차단


 */
public class FallCoinOnBoard {

    final static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    static int cnt;

    static class Coin {
        int x;          // 열
        int y;          // 행

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void solution(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int n = board.length;       // 행
        int m = board[0].length;    // 열
        cnt = Integer.MAX_VALUE;

        // 동전의 위치 파악
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {       // 행(y)
            for (int j = 0; j < m; j++) {   // 열(x)
                if (board[i][j] == 'o') {
                    coins.add(new Coin(j, i));
                }
            }
        }
        Coin coin1 = coins.get(0);
        Coin coin2 = coins.get(1);

        // backtracking
        backTracking(board, m, n, coin1.x, coin1.y, coin2.x, coin2.y, 0);
        System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);
    }

    // m,n: 보드의 크기, x,y: 동전의 위치, moveCnt: 이동횟수
    public static void backTracking(char[][] board, int m, int n, int x1, int y1, int x2, int y2, int moveCnt) {
        if (moveCnt >= 10) {
            return;
        }

        for (int[] dir : dirs) {
            // 동전 움직여보기
            int x1Next = x1 + dir[0];
            int y1Next = y1 + dir[1];
            int x2Next = x2 + dir[0];
            int y2Next = y2 + dir[1];

            // 동전이 떨어졌는지 체크
            int dropCnt = 0;
            if (x1Next < 0 || x1Next >= m || y1Next < 0 || y1Next >= n) {
                dropCnt++;
            }
            if (x2Next < 0 || x2Next >= m || y2Next < 0 || y2Next >= n) {
                dropCnt++;
            }

            // 두 동전 모두 다 떨어짐
            if (dropCnt == 2) {
                continue;
            }

            // 하나의 동전만 떨어짐
            if (dropCnt == 1) {
                cnt = Math.min(cnt, moveCnt + 1);
                return;
            }

            // 움직인 방향이 벽이었다면 다시 원위치
            if (board[y1Next][x1Next] == '#') {
                x1Next = x1;
                y1Next = y1;
            }
            if (board[y2Next][x2Next] == '#') {
                x2Next = x2;
                y2Next = y2;
            }

            backTracking(board, m, n, x1Next, y1Next, x2Next, y2Next, moveCnt + 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'.','#'}, {'.','#'}, {'.','#'}, {'o','#'}, {'o','#'}, {'#','#'}};
        solution(board);

        board = new char[][] {{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '.', '#'}, {'.','o','.'}, {'#','#','#'}};
        solution(board);

        board = new char[][] {{'#', '#', '#'}, {'.', 'o', '.'}, {'#', '#', '#'}, {'.','o','.'}, {'#','#','#'}};
        solution(board);
    }
}
