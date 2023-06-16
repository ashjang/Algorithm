package practice;

/*
    Practice2
    숫자 7193은 7193도 소수이고, 719, 71, 7도 다 소수이다.
    n이 주어졌을 때, n자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성

    ex) n:3     출력: 233,239,293,311,313,317,373,379,593,599,719,733,739,797
 */

/*
    가능풀이
    1. 맨처음 자리도 소수(한자리: 2,3,5,7)
        그다음 자리(2,5로 나누어 떨어지는 경우 제외:0,2,4,6,8,5)
 */

import java.util.ArrayList;

public class FindPrime {

    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();

        // 맨앞의 숫자가 소수려면 아래의 4개만 가능!
        int[] primeNum = {2,3,5,7};
        for (int i = 0; i < primeNum.length; i++) {
            // backTracking()
            backTracking(primeNum[i], 1, n);
        }

        return result;
    }

    // prime: 검사하려는 숫자, len: 수의 길이, n: 자리수
    public static void backTracking(int prime, int len, int n) {
        if (len >= n) {
            result.add(prime);
            return;
        }

        // 한 자리에 올 수 있는 수는 0~9
        for (int i = 0; i < 10; i++) {
            // 2와 5로 떨어지지 않는 숫자일 때
            if (i % 2 != 0 || i != 5) {
                int primeCandidate = prime * 10 + i;
                if (isPrime(primeCandidate)) {
                    backTracking(primeCandidate, len + 1, n);
                }
            }
        }
    }

    // 약수를 구하는 방식에서 소수인지 아닌지 확인
    public static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
