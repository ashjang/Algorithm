package practice;

/*
    Practice3
    sols 배열에 오지선다 문제의 정답들이 있다.
    3번 연속해서 같은 정답이 있는 경우가 없다.
    이떄 문제를 찍어서 풀때, 5점 이상을 받을 경우의 수?
    문제는 총10문제.

    ex)
    sols: {1,2,3,4,5,1,2,3,4,5}
    output: 261622
 */

/*
    <가능풀이>
    경우의 수 -> 모든 경우를 알아야함
    백트래킹? -> 조건 존재해야함

    조건1.
    찍는다? 2번 연속해서 같은 정답은 존재!
        => 1번, 1번. 그 다음에는 1이 올 수 없고 2~5까지 가능!
    조건2.
    5점 이상 경우의 수.
        => 문제를 찍을 때, 6번까지 풀었는데 다 틀리면 남은 문제 다 맞아도 4점. 5점을 못 넘기니까, pruning.

 */

public class QuizScoreUp5 {

    final static int numOfProblems = 10;
    static int cnt;     // 결과값 출력

    public static void solution(int[] sols) {
        if (sols == null || sols.length != numOfProblems) {
            return;
        }

        cnt = 0;
        int[] submit = new int[numOfProblems];

        // backtracking
        backTracking(sols, submit, 0, 0);
        System.out.println(cnt);
    }

    // submit: 제출, correctCont: 맞은 개수, idx: 현재 풀고 있는 index
    public static void backTracking(int[] sols, int[] submit, int correctCnt, int idx) {
        // 앞으로의 문제를 다 맞아도 5점 못 넘기는 경우(pruning)
        if (numOfProblems - idx + correctCnt < 5) {
            return;
        }

        if (idx == numOfProblems) {     // 10번까지 풀었을 때
            if (correctCnt >= 5) {
                cnt++;
            }
        } else {            // 못 풀었을 때
            int twoInRow = 0;   // 연속하여 같은 값을 가지는 정답을 세는 변수
            if (idx >= 2) {
                if (submit[idx - 1] == submit[idx - 2]) {       // 연속 같은 값 2개 됐을 때, 그 수는 바로 그 다음의 값이 되지 못하도록
                    twoInRow = submit[idx - 1];
                }
            }

            for (int i = 1; i <= 5; i++) {
                if (i == twoInRow) {
                    continue;
                }

                submit[idx] = i;
                if (sols[idx] == i) {       // 정답일 때
                    backTracking(sols, submit, correctCnt + 1, idx + 1);
                } else {                    // 오답일 때
                    backTracking(sols, submit, correctCnt, idx + 1);
                }
                submit[idx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] sols = {1,2,3,4,5,1,2,3,4,5};
        solution(sols);

        sols = new int[]{1,1,2,2,3,3,4,4,5,5};
        solution(sols);
    }
}
