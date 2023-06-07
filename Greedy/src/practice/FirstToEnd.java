package practice;

/*
    Practice1
    정수형 nums 배열. 각 원소의 값은 해당 위치에서 오른쪽으로 이동 가능한 최대 값.
    첫번째 위치에서 가장 끝까지 이동이 가능한지 판별
    이동 가능시 true, 아니면 false 반환

    ex)
    nums: 2,3,0,1,4
    출력: true

    nums: 3,0,0,1,1
    출력: true

    nums: 3,2,1,0,4
    출력: false
 */

/*
    가능 풀이
    1. 재귀호출 -> O(n^2)
    2. 그리디: 각 자리에서 출발해서 맨 끝까지 도달 가능?
    ex) 첫번쨰로 2에서 시작하면 0으로 가는데 더 이상 불가능.
        그럼 그다음 3에서 시작하면 맨 끝까지 가능. 정답!
    : 각 선택이 그 다음선택에 있어서 영향을 끼치지 않고 각 선택이 모여 전체 해답이 되므로 그리디 가능

    2번 사용
 */


public class FirstToEnd {
    public static boolean solution(int[] nums) {
        // 현재 위치
        int position = 0;

        for (int i = 0; i < nums.length; i++) {
            // 이전에 설정한 position 판별
            if (position < i) {         // position = [마지막-1]
                return false;
            } else if (position >= nums.length - 1) {           // 끝까지 도달
                return true;
            }

            // 현재 위치에서 갈 수 있는 최대 위치를 뽑음.
            position = Math.max(position, i + nums[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,3,0,1,4}));
        System.out.println(solution(new int[]{3,0,0,1,1}));
        System.out.println(solution(new int[]{3,2,1,0,4}));
    }
}
