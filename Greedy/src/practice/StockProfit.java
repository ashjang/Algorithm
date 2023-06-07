package practice;

/*
    Practice2
    양의 정수 배열 prices. 각 원소는 날짜 별 주식 가격.
    한 번에 한 주만 보유 가능할 때 prices를 보고 사고 팔기를 반복하여 얻을 수 있는 최대 수익 반환

    ex)
    prices: 5,1,6,4,3,5
    출력: 7

    prices: 1,2,3,4,5
    출력: 4
 */

/*
    가능 풀이
    1. 각 날짜별로 그 가격으로 샀을 때 언제 팔면 수익이 나는지를 먼저 뽑고,
        그 기간들이 오버랩 되지 않도록 더할 수 있는 case들을 다 더해서 그 중에 max 값을 뽑아냄.
    2. 그리디: 인접한 원소들에서 당장 수익이 나는 것들을 더하기
    : 각 선택이 그 다음선택에 있어서 영향을 끼치지 않고 각 선택이 모여 전체 해답이 되므로 그리디 가능

    2번 사용!
 */

public class StockProfit {
    public static int solution(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 가격이 전날보다 더 비싸면 이익
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5,1,6,4,3,5}));
        System.out.println(solution(new int[]{1,2,3,4,5}));
        System.out.println(solution(new int[]{5,4,3,2,1}));
    }
}
