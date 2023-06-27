# Minimum Spanning Tree (최소 신장 트리)

### : 그래프 상의 모든 노드들을 _**사이클 없이**_ 최소 비용으로 연결하는 방법

- 크루스칼
- 프림
- 
## 크루스칼 알고리즘 

### : 간선 중 최소 값을 가진 간선부터 연결

- when? 주로 간선 수가 적을 때 사용
- O(ElogE)
- Union Find 배열 사용

### main
### practice


## 프림 알고리즘

### : 임의의 노드에서 시작하여 연결된 노드들의 간선 중 낮은 가중치를 갖는 간선부터 연결

- when? 주로 간선 수가 많을 때 사용
- O(ElogV)  => priority queue
- visited 배열 사용

### main
### practice


###### 참고: https://harimms.tistory.com/284