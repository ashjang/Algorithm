/*
    해결방법
    ---

    이진탐색으로 풀이 가능

    걸리는 최소 시간: 0, 최대 시간(더 오래걸리는 의사가 전부 맡음): 10*6=60
    0~60의 중앙값 30분 안에 몇명까지 진료 가능?
        의사 1번은 30/7=4명. 의사 2번은 30/10=3명.        => 오버
        0~29의 중앙값 15분 안에 몇명까지 진료 가능?
            의사 1번은 15/7=2명. 의사 2번은 15/10=1명.    => 언저
            16~29의 중앙값 22...
            23~29의 중앙값 26...
            27~29의 중앙값 28.
 */

import java.util.Arrays;

public class Practice1 {

    public static int solution(int n, int[] times) {
        if (times == null || times.length == 0) {
            return -1;
        }

        Arrays.sort(times);
        int left = 0;
        int right = times[times.length - 1] * n;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            // 몇명 환자 가능?
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }

            if (cnt < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7,10};
        System.out.println(solution(n, times));
    }
}