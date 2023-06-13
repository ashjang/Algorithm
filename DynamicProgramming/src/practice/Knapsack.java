package practice;

/*
    Practice2
    배낭에 물품을 담을 때, 배낭은 k 무게만큼 담을 수 있다.
    n개의 물품가 있고 이의 무게와 가치 정보는 items 2차월 배열에.
    최대 가치가 되도록 물품을 담을 때의 가치 출력

    ex)
    items: {{6,13}, {4,8}, {3,6} ,{5,12}}   n: 4    k: 7
    output: 14
 */

/*
    가능 풀이
    1. 모든 경우의 수를 다 봐야함.
        (이중 for)차례로 경우의 수를 구해 가치를 저장해서 그 가치값들을 비교
        => k가 높을수록, items가 높을수록 복잡함.
    2. 부분문제로 풀 수 있는가? 겹치는 부분이 있는가?
        예를 들어, {5,가치}가 있어서 7-5=2만큼 더 담을 수 있는데 이전에 k=2인 값이 있다면 그것을 이용
        ==> 부분문제
        ==> dynamic programming
        ==> tabulation - 작은 순서대로
        k       1   2   3   4   5   6   7
        {3,6}   0   0   6   6   6   6   6
        {4,8}   0   0   6   8   8   8   14([7]-[4]=[3];6)
        {5,12}  0   0   6   8   12  12  14
        {6,13}  0   0   6   8   12  13  14
 */

public class Knapsack {
    public static int solution(int[][] items, int n, int k) {
        int[][] dp = new int[n + 1][k + 1];

        // i: 물품, j: 무게
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (items[i][0] > j) {              // 물품무게 > k이면, 이전 물품의 가치를 담기
                    dp[i + 1][j] = dp[i][j];
                } else {                            // 물품 넣을 수 있을 때, 기존값(이전물품) vs 현재물품+남은무게의물품(여러물품)
                    dp[i + 1][j] = Math.max(dp[i][j],  dp[i][j - items[i][0]] + items[i][1]);
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        
        return dp[n][k];
    }

    public static void main(String[] args) {
        int[][] items = {{6,13}, {4,8}, {3,6} ,{5,12}};
        System.out.println(solution(items, 4, 7));
    }
}
