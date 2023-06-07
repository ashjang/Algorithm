package practice;

/*
    Practice3
    양의 정수 n이 주어지고 다음 연산을 수행가능할 때,
        1. n이 짝수인 경우, 2로 나누기
        2. n이 홀수인 경우, 1을 더하거나 1을 뻄
    주어진 n이 1이 되는데 필요한 최소한의 연산 횟수 반환하기

    ex)
    n: 8        output: 3
    n: 7        output: 4
    n: 9        output:4
 */

/*
    가능 풀이
    1. 케이스 다 해보기 -> 복잡도 많이 듬
    2. 그리디: 규칙 존재
    -> 4는 2번만에, 3은 더하는 것보다 빼고 나누는 것이 빠르고,
        그 외 홀수는 빼는 것으로 하면 손해X
        즉, 짝수는 2로 나누기만 하며 되고 홀수는 4의 배수로 떨어지는 수가 되도록 빼거나 더하는 것이 효율
 */

public class MinNumCalculate {
    public static int solution(int n) {
        // 예외 처리
        if (n == 0 || n == 2) {
            // 한 번 연산
            return 1;
        }
        if (n == 1) {
            return 0;
        }

        int cnt = 0;
        while (n != 1) {
            if (n == 3) {
                cnt += 2;
                break;
            }

            if (n % 2 == 0) {       // 짝수
                n /= 2;
            } else if ((n + 1) % 4 == 0) {      // 홀수 & 4의 배수 가능토록
                n += 1;
            } else if ((n - 1) % 4 == 0) {      // 홀수 & 4의 배수 가능토록
                n -= 1;
            }

            cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(solution(8));
        System.out.println(solution(7));
        System.out.println(solution(9));
        System.out.println(solution(6));
    }
}
