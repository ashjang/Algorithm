package practice;

/*
    Practice 1
    정수 n이 주어졌을 때 아래의 연산을 통해 1로 만들기
        1. 2로 나누어 떨어지면 2로 나누기
        2. 3으로 나누어 떨어지면 3으로 나누기
        3. 1 빼기
    위의 연산을 통해 1로 만들 때 필요한 최소한의 연산 횟수

    ex)
    n: 2        output: 1
    n: 9        output: 2
 */

/*
    가능 풀이
    1. dp - tabulation
    : dp memory를 만듬.
 */

public class Make1MinCalculateNum {
    public static int solution(int n) {
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            // 1을 먼저 빼보기
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지면 1을 빼서 연산하는 횟수와 2를 나누어 연산하는 횟수와 비교하여 최솟값
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3로 나누어 떨어지면 1을 빼서 연산하는 횟수와 3을 나누어 연산하는 횟수와 비교하여 최솟값
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(2));
        System.out.println(solution(4));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }
}
