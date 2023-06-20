package main;

import java.util.ArrayList;

// 효율적이지 않음: 매번 최소간선을 고르기 위해 반복문을 돌리는데 매번 최소간선을 뽑아야하는 것이 번거로움

public class Main {

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        // 편의상 0번은 사용 X
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        // 그래프 구성
        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        // 최단 경로 기록 DP 메모리
        int[] dpList = new int[v + 1];

        // 무한대로 초기화
        for (int i = 1; i < v + 1; i++) {
            dpList[i] = Integer.MAX_VALUE;
        }
        dpList[start] = 0;

        // 모든 노드 탐색
        boolean[] visited = new boolean[v + 1];
        for (int i = 0; i < v; i++) {
            int minDist = Integer.MAX_VALUE;        // 다음으로 가장 짧은 간선
            int curIdx = 0;

            // 어떤 노드를 선택? :최소간선
            for (int j = 1; j < v + 1; j++) {
                // 방문한적이 없고 거리가 minDist보다 작으면 최소경로로 설정
                if (!visited[j] && dpList[j] < minDist) {
                    minDist = dpList[j];
                    curIdx = j;
                }
            }

            visited[curIdx] = true;
            // 선택된 노드의 인접노드 weight를 갱신
            for (int j = 0; j < graph.get(curIdx).size(); j++) {
                Node adjNode = graph.get(curIdx).get(j);
                if (dpList[adjNode.to] > dpList[curIdx] + adjNode.weight) {
                    dpList[adjNode.to] = dpList[curIdx] + adjNode.weight;
                }
            }
        }

        // result
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
        // 1번 노드에서 2번 노드로의 가중치가 2.
        // 1번 노드에서 3번 노드로의 가중치가 3.
        // 2번 노드에서 3번 노드로의 가중치가 4.
        // 등등...
        int[][] data = {{1,2,2}, {1,3,3}, {2,3,4}, {2,4,5}, {3,4,6}, {5,1,1}};

        // 1번 노드에서 각 노드까지의 최단 경로
        dijkstra(5, data , 1);
    }
}