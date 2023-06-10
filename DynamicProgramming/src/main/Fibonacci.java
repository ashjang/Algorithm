package main;

/*
    피보나치 수열
 */

public class Fibonacci {
    // 재귀함수 방식 : 계산했던 부분도 다시 계산
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    // DP 방식 - tabulation(O(n))
    public static int fibDP(int n) {
        int[] dp = new int[n < 2 ? 2 : n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // DP 방식 - memoization(O(n))
    static int[] dp = new int[8];
    public static int fibDP2(int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibDP2(n - 1) + fibDP2(n - 2);

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
        System.out.println(fibDP(7));
        System.out.println(fibDP2(7));
    }
}