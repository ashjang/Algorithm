package bellman;

public class Main {

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void bellmanFord(int v, int e, int[][] data, int start) {
        // 간선 정보 입력
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            edges[i] = new Edge(data[i][0], data[i][1], data[i][2]);
        }

        // 편의상 1번부터 시작
        int[] dpList = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            dpList[i] = Integer.MAX_VALUE;
        }
        dpList[start] = 0;

        boolean isMinusCycle = false;
        // 음수 사이클 체크를 위해 v+1만큼 돌림
        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edges[j];

                if (dpList[cur.from] == Integer.MAX_VALUE) {
                    continue;
                }

                if (dpList[cur.to] > dpList[cur.from] + cur.weight) {
                    dpList[cur.to] = dpList[cur.from] + cur.weight;

                    // 음수 사이클 체크
                    if (i == v) {
                        isMinusCycle = true;
                    }
                }
            }
        }

        // result
        System.out.println("음수 사이클 발생: " + isMinusCycle);
        for (int i = 1; i < v + 1; i++) {
            if (dpList[i] == Integer.MAX_VALUE) {
                System.out.print("INF");
            } else {
                System.out.print(dpList[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,8}, {1,3,6}, {1,5,5}, {2,3,-5}, {2,4,1}, {2,6,4}, {3,4,4}, {4,7,3}, {5,6,5}, {6,2,0}, {6,7,-7}};
        bellmanFord(7,11,data,1);

        data = new int[][] {{1,2,8}, {1,3,6}, {1,5,5}, {2,3,-5}, {2,4,1}, {2,6,4}, {3,4,4}, {4,7,3}, {5,6,5}, {6,2,-5}, {6,7,-7}};
        bellmanFord(7,11,data,1);
    }
}
