package floyd;

public class Main {

    static int[][] dpList;
    static final int INF = 1000000000;          // MAX_VALUE로 구현하면 각 업데이트 이뤄질 때 (MAX_VALUE + 알파값)하면 오버플로우 발생

    public static void floyd(int v, int e, int[][] data, int start) {
        // inital set
        dpList = new int[v + 1][v + 1];
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                // 대각이 아닐 때 무한대로
                if (i != j) {
                    dpList[i][j] = INF;
                }
            }
        }

        // graph 구성
        for (int i = 0; i < e; i++) {
            // [출발][도착] = 가중치
            dpList[data[i][0]][data[i][1]] = data[i][2];
        }

        // floyd
        for (int k = 1; k < v + 1; k++) {
            // i->k->j의 최단 경로 구하기
            for (int i = 1; i < v + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    // 거리 정보 업데이트
                    if (dpList[i][k] != INF && dpList[k][j] != INF) {
                        dpList[i][j] = Math.min(dpList[i][j], dpList[i][k] + dpList[k][j]);
                    }
                }
            }
        }

        // result
        for (int i = 1; i < v + 1; i++) {
            for (int j = 1; j < v + 1; j++) {
                if (dpList[i][j] >= INF) {
                    System.out.printf("%5s ", "INF");
                } else {
                    System.out.printf("%5d ", dpList[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // 음수사이클 존재X
        int[][] data = {{1,2,8}, {1,3,6}, {1,5,5}, {2,3,-5}, {2,4,1}, {2,6,4}, {3,4,4}, {4,7,3}, {5,6,5}, {6,2,0}, {6,7,-7}};
        floyd(7,11,data,1);

        System.out.println();
        // 음수사이클 존재O
        data = new int[][] {{1,2,8}, {1,3,6}, {1,5,5}, {2,3,-5}, {2,4,1}, {2,6,4}, {3,4,4}, {4,7,3}, {5,6,5}, {6,2,-5}, {6,7,-7}};
        floyd(7,11,data,1);
    }
}
