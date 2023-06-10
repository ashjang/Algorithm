package practice;

/*
    Practice1
    정수형 배열 nums. 연속된 부분 배열의 합 중 가장 큰 값?

    ex)
    nums: -5,0,-3,4,-1,3,1,-5,8
    output: 10

    nums: 5,4,0,7,8
    output: 24
*/

/*
    가능 풀이
    1. 투 포인터 이용: p1~p2의 sum 구하고 p1,p2 중 작은 숫자를 옮기는데, 이때 옮겼을 때의 숫자가 더 커야함. 아니면 옮기지 X.
        => 복잡함
    2. 분할정복: 각각의 케이스들을 전부 구하고 합을 구함
 */

public class SubArrSumMax {

    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        return divideSubArray(nums, 0, nums.length - 1);
    }

    public static int divideSubArray(int[] nums, int left, int right) {
        // 탈출 조건
        if (left == right) {
            return nums[left];
        }

        // 중앙값 - 오버플로우 방지(left+right가 int형 범위를 넘어가는 것)
        int mid = left + (right - left) / 2;
        int maxLeft = divideSubArray(nums, left, mid);
        int maxRight = divideSubArray(nums, mid + 1, right);

        int maxArr = getMaxSubArray(nums, left, mid, right);

        System.out.println(Math.max(maxLeft, Math.max(maxArr, maxRight)));
        return Math.max(maxLeft, Math.max(maxArr, maxRight));
    }

    public static int getMaxSubArray(int[] nums, int left, int mid, int right) {
        // 중앙에서 왼쪽까지의 최댓값 찾기
        int sumLeft = 0;
        int maxLeft = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sumLeft += nums[i];
            maxLeft = Math.max(maxLeft, sumLeft);
        }

        // 중앙에서 오른쪽까지의 최댓값 찾기
        int sumRight = 0;
        int maxRight = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sumRight += nums[i];
            maxRight = Math.max(maxRight, sumRight);
        }

        // 부분배열의 합
        return maxLeft + maxRight;
    }

    public static void main(String[] args) {
        int[] nums = {-5,0,-3,4,-1,3,1,-5,8};
        System.out.println(solution(nums));

        nums = new int[]{5,4,0,7,8};
//        System.out.println(solution(nums));
    }
}
