package practices;

/*
    n개의 도시와, 한 도시에서 출발해 다른 도시에 도착하는 m개의 버스.
    각 버스는 한 번 사용할 때 필요한 비용이 있음.
    모든 도시의 쌍(A,B)에 대해 도시 A에서 B로 가는데 필요한 비용의 최솟값?
    (시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있고, 갈 수 없는 경로는 0.)

    ex)
    city:5      bus:14      busInfo: {{1,2,2},{1,3,3},{1,4,1},{1,5,10},{2,4,2},{3,4,1},{3,5,1},
                                    {4,5,3}, {3,5,10}, {3,1,8}, {1,4,2}, {5,1,7}, {3,4,2}, {5,2,4}}
    output:     0   2   3   1   4
                12  0   15  2   5
                8   5   0   1   1
                10  7   13  0   3
                7   4   10  6   0
 */

/*
    접근 풀이
    - 모든 도시의 쌍, 최솟값       => 최단경로 중 Floyd

 */

public class CitiesToCities {

    static int[][] dpList;
    static final int INF = 1000000000;

    public static void solution(int city, int bus, int[][] busInfo) {
        // 자기 자신으로 가는 것은 0으로 초기화, 외엔 INF
        dpList = new int[city + 1][city + 1];
        for (int i = 1; i < city + 1; i++) {
            for (int j = 1; j < city + 1; j++) {
                if (i != j) {
                    dpList[i][j] = INF;
                }
            }
        }

        // 간선 정보 업데이트(같은 간선은 weight가 더 작은값으로)
        for (int i = 0; i < bus; i++) {
            dpList[busInfo[i][0]][busInfo[i][1]] = Math.min(busInfo[i][2], dpList[busInfo[i][0]][busInfo[i][1]]);
        }

        // 플로이드
        floyd(city);

        // result
        for (int i = 1; i < city + 1; i++) {
            for (int j = 1; j < city + 1; j++) {
                if (dpList[i][j] >= INF) {
                    System.out.printf("%5s ", "INF");
                } else {
                    System.out.printf("%5d ", dpList[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void floyd(int v) {
        // i에서 시작하여 j에 도착하는데, k번을 거쳐가는 경로
        for (int k = 1; k < v + 1; k++) {
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // i->k, k->j의 경로가 있어야 함
                    if (dpList[i][k] != INF && dpList[k][j] != INF) {
                        dpList[i][j] = Math.min(dpList[i][j], dpList[i][k] + dpList[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int city = 5;
        int bus = 14;
        int[][] busInfo = {{1,2,2},{1,3,3},{1,4,1},{1,5,10},{2,4,2},{3,4,1},{3,5,1},
                        {4,5,3}, {3,5,10}, {3,1,8}, {1,4,2}, {5,1,7}, {3,4,2}, {5,2,4}};
        solution(city,bus,busInfo);
    }
}
