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

public class FallCoinOnBoard {

    final static int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public static void solution(char[][] board) {

    }

    public static void main(String[] args) {
        char[][] board = {{'.','#'}, {'.','#'}, {'.','#'}, {'o','#'}, {'o','#'}, {'#','#'}};
        solution(board);
    }
}
