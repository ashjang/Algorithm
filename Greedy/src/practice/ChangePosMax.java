package practice;

/*
    Practice 5
    정수 num에서 두 자리를 최대 한 번만 교체하여 얻을 수 있는 최댓값 출력

    ex)
    num: 2376       output: 7236
    num: 7116       output:7611
 */

/*
    가능풀이
    : 가장 큰 숫자를 뽑아 맨 앞자리.
    but, 이미 맨 앞자리에 큰 숫자가 있다면, 그 다음 자리에 큰 숫자가 오도록.
    큰 숫자를 먼저 찾아서 이 숫자보다 더 큰 숫자가 나올 때까지 앞(전 자리)으로 복붙. 더 큰 숫자가 나왔을 때,
    멈춰 달라지는 첫번째 지점의 숫자와 교환
    ex) 7116 -> 7666 -> 원래 숫자와 달라지는 첫번째 자리=백의 자리와 일의 자리를 교체
 */

public class ChangePosMax {
    public static int solution(int num) {
        char[] cArr = String.valueOf(num).toCharArray();
        int[] maxArr = new int[cArr.length];            // max 값

        int max = 0;
        // 7116 -> 7666으로 만드는 작업
        for (int i = cArr.length - 1; i >= 0; i--) {
            max = Math.max(max, cArr[i] - '0');
            maxArr[i] = max;
        }

        for (int i = 0; i < cArr.length - 1; i++) {
            // max값보다 작은 값이 등장하는 위치 찾았을 때(ex.백의 자리)
            if (cArr[i] - '0' < maxArr[i + 1]) {
                // max값의 원래 위치(ex.일의 자리) 찾고 swap(ex.백<->일)
                for (int j = cArr.length - 1; j >= i + 1; j--) {
                    if (cArr[j] - '0' == maxArr[i + 1]) {
                        char tmp = cArr[j];
                        cArr[j] = cArr[i];
                        cArr[i] = tmp;
                        return Integer.parseInt(String.valueOf(cArr));
                    }
                }
            }
        }

        return num;
    }


    public static void main(String[] args) {
        System.out.println(solution(2736));
        System.out.println(solution(7116));
        System.out.println(solution(91));
    }
}
