/*
    해결방법
    ---

    연속해서 n개를 골랐을 때 종류가 몇개인지?

    투포인터로 풀이 가능
 */

public class Practice2 {

    private static int solution(int n, int[] plates, int types, int coupon) {
        if (plates == null || plates.length == 0) {
            return -1;
        }

        int[] selected = new int[types + 1];
        int cnt = 0;            // plates에 중복없이 초밥의 종류 개수
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (selected[plates[i]] == 0) {
                cnt++;
            }

            selected[plates[i]]++;
        }
        max = cnt;

        for (int i = 1; i < plates.length; i++) {
            if (max <= cnt) {
                // 쿠폰 먹은 적 없을 때,
                if (selected[coupon] == 0) {
                    max = cnt + 1;
                } else {
                    max = cnt;
                }
            }

            int p1 = i - 1;
            int p2 = (i + n - 1) % plates.length;

            selected[plates[p1]]--;
            // 존재하는 같은 종류의 초밥을 다 먹었을 때, 그 종류를 제거
            if (selected[plates[p1]] == 0) {
                cnt--;
            }

            // 먹어본 적 없는 종류라면, 그 종류 추가
            if (selected[plates[p2]] == 0) {
                cnt++;
            }
            selected[plates[p2]]++;
        }
        
        return max;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] plates = {7,9,7,30,2,7,9,25};
        int types = 30;
        int coupon = 30;
        System.out.println(solution(n, plates, types, coupon));
    }


}
