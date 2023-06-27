package Kruskal;

import java.util.Arrays;

public class Main {
    // union
    static int parents[];

    public static int kruskal(int[][] data, int v, int e) {
        int weightSum = 0;

        // 간선을 기준으로 오름차순 sort
        Arrays.sort(data, (x,y) -> x[2] - y[2]);

        // 초기세팅
        parents = new int[v + 1];       // 1부터 시작
        for (int i = 1; i < v + 1; i++) {
            parents[i] = i;
        }

        // 알고리즘
        for (int i = 0; i < e; i++) {
            // 서로 연결되어 있지 않다면(부모가 같지 않음: 사이클X) 연결
            if (find(data[i][0]) != find(data[i][1])) {
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            }
        }

        return weightSum;
    }

    // 연결됐을 때, 두 노드를 같은 집합으로 묶어줌 : 자기 자신의 parents 수정
    public static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if (aP != bP) {
            parents[bP] = aP;
        }
    }

    // 노드가 최종적으로 어디로 연결? : 연쇄된 노드의 parents 수정
    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }


    public static void main(String[] args) {
        int v= 7;
        int e = 10;
        int[][] graph = {{1,3,1}, {1,2,9}, {1,6,8}, {2,4,13}, {2,5,2},
                {2,6,7}, {3,4,12}, {4,7,17}, {5,6,5}, {5,7,20}};
        System.out.println(kruskal(graph, v, e));
    }
}