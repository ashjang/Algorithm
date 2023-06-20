package main;

// 다익스트라 우선순위 큐 사용

import java.util.ArrayList;
import java.util.PriorityQueue;

public class PriorityQueueMain {

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

        // 간선정보가 작은 것부터 먼저 나옴 => 최소간선에 대해 탐색할 필요가 없음
        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            // 최소경로가 아님
            if (dpList[curNode.to] < curNode.weight) {
                continue;
            }

            // 인접 노드를 탐색하며 최단 경로 갱신
            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dpList[adjNode.to] > curNode.weight + adjNode.weight) {
                    dpList[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.offer(new Node(adjNode.to, dpList[adjNode.to]));
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
