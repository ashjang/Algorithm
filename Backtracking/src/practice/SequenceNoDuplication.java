package practice;

/*
    Practice1
    정수 n,m이 주어지고 1~n까지의 정수 중에서 중복없이 m개를 고른 순열을 출력

    ex)
    n: 3, m:2
    output: [1,2], [1,3], [2,1], [2,3], [3,1], [3,2]
 */

/*
    가능 풀이
    순열! DFS!
 */

import java.util.Arrays;

public class SequenceNoDuplication {

    public static boolean[] visited;
    public static int[] output;


    public static void solution(int n, int m) {
        visited = new boolean[n];
        output = new int[m];
        permutation(n, m, 0);
    }

    public static void permutation(int n, int m, int depth) {
        if (depth == m) {
            System.out.println(Arrays.toString(output));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = i + 1;
                permutation(n, m, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        solution(3,2);
        System.out.println();
        solution(4,3);
    }
}
