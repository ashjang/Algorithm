package practices;

/*
    Practice1
    2차원 배열 data에 그래프 데이터가 주어짐. 무방향이고 간선에 가중치 값이 있는 그래프.
    1번 정점에서 N번 정점으로 최단 경로로 이동할 때, 두 정점을 경유해서 가려고 한다.
    1번 정점에서 출발하여 두 정점을 경유하여 N번 정점으로 가는 최단 경로?

    ex)
    data: {{1,2,3}, {1,3,5}, {1,4,4}, {2,3,3}, {2,4,5}, {3,4,1}}
    start: 1        n: 4        via1: 2     via2: 3
    output: 7
 */

/*
    가능 풀이
    - 문제에 음수가 없으므로 다익스트라(:한노드에서 다른 모든 노드들까지의 최단경로)
    - 두 정점 경유 : start->A->B->end
                or start->B->A->end
    so, start->A의 최단경로 + A->B의 최단경로 + B->end의 최단경로
        start->B의 최단경로 + B->A의 최단경로 + A->end의 최단경로
    를 비교해서 더 짧은 경로를 택
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class OneToOne {

    static ArrayList<ArrayList<Node>> graph;
    final static int INF = 1000000000;

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int[][] data, int v, int via1, int via2, int start, int n) {
        int case1 = 0;
        int case2 = 0;

        // graph 구성
        graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        // case1: start -> A -> B -> end
        case1 = dijkstra(v, start, via1);
        case1 += dijkstra(v, via1, via2);
        case1 += dijkstra(v, via2, n);

        // case2: start -> B -> A -> end
        case2 = dijkstra(v, start, via2);
        case2 += dijkstra(v, via2, via1);
        case2 += dijkstra(v, via1, n);

        if (case1 >= INF && case2 >= INF) {
            return -1;
        } else {
            return Math.min(case1, case2);
        }
    }

    public static int dijkstra(int v, int start, int end) {
        // 간선정보가 작은 것부터 먼저 나옴 => 최소간선에 대해 탐색할 필요가 없음
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        // dpList 메모리 초기화
        int[] dpList = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            dpList[i] = INF;
        }
        dpList[start] = 0;

        // 방문배열
        boolean[] visited = new boolean[v + 1];

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (visited[curNode.to]) {
                continue;
            }
            visited[curNode.to] = true;

            // 현재 노드의 인접노드
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                // 인접한 노드에서 가려고 하는 노드가 방문된 적 없고 거리가 더 짧다면 갱신
                if (!visited[adjNode.to] && dpList[adjNode.to] > curNode.weight + adjNode.weight) {
                    dpList[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dpList[adjNode.to]));
                }
            }
        }

        return dpList[end];
    }

    public static void main(String[] args) {
        int[][] data ={{1,2,3}, {1,3,5}, {1,4,4}, {2,3,3}, {2,4,5}, {3,4,1}};
        int v = 4;
        int via1 = 2;
        int via2 = 3;
        int start = 1;
        int n = 4;
        System.out.println(solution(data,v,via1,via2,start,n));
    }
}
