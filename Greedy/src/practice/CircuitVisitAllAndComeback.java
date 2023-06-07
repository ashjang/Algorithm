package practice;

/*
    Practice4
    원형 루트 상에 n개 주유소.
    각 주유소의 가수 보유량은 gas 배열에 주어지고, 해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에.
    어떤 위치에서 차량이 가스를 채워 출발하면 모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지 계산하기

    ex)
    gas: 1,2,3,4,5      cost: 3,4,5,1,2
    output: 3

    gas: 2,3,4          cost: 3,4,3
    output: -1
 */

/*
    가능 풀이
    1. 먼저 출발 가능 원소를 찾아 되는 것들을 for문으로 또 돌아서 해보기 => 복잡도 높음
    2. 그리디
    -> 먼저 출발 가능 원소를 찾고(=gas-cost가 양수인 것들),
      각 gas-cost의 값들을 다 더해서 0 이상이면 가능으로 판단.

    2번 사용!
 */

public class CircuitVisitAllAndComeback {
    public static int solution(int[] gas, int[] cost) {
        // 예외처리
        if (gas == null || cost == null) {
            return -1;
        }
        if (gas.length != cost.length) {
            return -1;
        }

        int curGas = 0;
        int totalGas = 0;
        int startPos = 0;

        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];

            if (curGas < 0) {
                startPos = i + 1;
                curGas = 0;
            }
        }

        return totalGas >= 0 ? startPos : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution(gas,cost));

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(solution(gas,cost));
    }
}
