package main;/*
    거스름돈 문제
 */

import java.util.HashMap;
import java.util.Map;

public class ChangeCoins {
    public static void getChangeCoins(int receivedMoney, int price) {
        final int[] coins = {500, 100, 50, 10, 5, 1};

        // 어떤 동전이 몇 개인지
        HashMap<Integer, Integer> result = new HashMap<>();

        // 잔돈 계산
        int change = receivedMoney - price;
        // 잔돈 개수
        int cnt = 0;

        for (int i = 0; i < coins.length; i++) {
            if (change < coins[i]) {
                continue;
            }

            int q = change / coins[i];
            result.put(coins[i], result.getOrDefault(coins[i], 0) + q);

            change %= coins[i];
            cnt += q;
        }

        System.out.println("거스름돈 동전 개수: " + cnt);
        for (Map.Entry<Integer, Integer> item : result.entrySet()) {
            System.out.println(item.getKey() + ": " + item.getValue());
        }
    }

    public static void main(String[] args) {
        getChangeCoins(1000, 100);
        getChangeCoins(1234, 500);
    }
}
