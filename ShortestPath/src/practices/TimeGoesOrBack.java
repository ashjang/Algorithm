package practices;

/*
    Practice2
    N개의 우주가 있고, N개의 우주 사이에 M개의 포탈과 W개의 웜홀.
    각 포탈에는 시간 비용이 있고, 포탈을 통해 우주를 이동했을 때 시간이 흘러 있다.
    웜홀에도 시간비용이 있는데, 웜홀을 통해 우주를 이동하는 경우는 시간이 거꾸로 흘러 있다.
    N개의 우주를 포탈과 웜홀을 통해 이동할 때, 출발했을 때보다 시간이 거꾸로 흘러가 있는 경우가 있는지 판단
    거꾸로 흘러가 있는 경우가 없으면 false, 있으면 true

    ex)
    n:3     m:3     w:1
    portal: {{1,2,2}, {1,3,4}, {2,3,1}}
    wormhole: {{3,1,3}}
    output: false
 */

/*
    접근방법
    - 포탈은 양의 간선, 웜홀은 음의 간선
    - 최단경로?: '시간이 거꾸로 흘러가 있는 경우' => bellman에서 *음수사이클*이 있는지를 판단하라는 것
 */

public class TimeGoesOrBack {
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

    final static int INF = 1000000000;
    static Edge[] edge;
    static int[] dpList;


    public static void solution(int n, int m, int w, int[][] portal, int[][] wormwhole) {
        // 초기세팅
        edge = new Edge[m + w];
        for (int i = 0; i < m; i++) {
            edge[i] = new Edge(portal[i][0], portal[i][1], portal[i][2]);
        }
        for (int i = 0; i < w; i++) {
            edge[m + i] = new Edge(wormwhole[i][0], wormwhole[i][1], -wormwhole[i][2]);
        }

        dpList = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dpList[i] = INF;
        }
        dpList[1] = 0;

        System.out.println(bellmanFord(n, m + w));
    }

    public static boolean bellmanFord(int v, int e) {
        boolean isMinusCycle = false;
        for (int i = 0; i < v + 1; i++) {
            for (int j = 0; j < e; j++) {
                Edge cur = edge[j];

                if (dpList[cur.from] >= INF) {
                    continue;
                }

                if (dpList[cur.to] > dpList[cur.from] + cur.weight) {
                    dpList[cur.to] = dpList[cur.from] + cur.weight;

                    // 한 사이클 더 돌았을 때 업데이트됐을 때
                    if (i == v) {
                        isMinusCycle = true;
                    }
                }
            }
        }
        return isMinusCycle;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int w = 1;
        int[][] portal = {{1,2,2}, {1,3,4}, {2,3,1}};
        int[][] wormwhole = {{3,1,3}};
        solution(n, m, w, portal, wormwhole);       // false

        n = 3;
        m = 2;
        w = 1;
        portal = new int[][] {{1,2,3}, {2,3,4}};
        wormwhole = new int[][] {{3,1,8}};
        solution(n, m, w, portal, wormwhole);       // true
    }
}
