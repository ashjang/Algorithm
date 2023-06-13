# Dynamic Programming (DP)

### : 큰 문제를 부분문제로 나눈 후, 답을 찾아가는 과정에서(=분할정복) *계산된 결과를 기록하고 재활용*하여 답을 구하는 것 
ex. 피보나치 수열

### 다른 알고리즘과의 차이점?
- divide and conquer : 분할정복은 부분문제가 중복되지 않지만(=독립) DP는 중복되어 재활용이 가능
- greedy algorithm : 탐욕은 순간순간의 최선을 통해 근사치 값을 얻는데, DP는 모든 방법을 확인 후 최적해를 얻음

### 구현방법
1. tabulation
   1. 상향식 접근(bottom-up)
   2. 작은 하위 문제들부터 풀이
   3. 모두 계산하면서 차례대로 위로 올라감
2. memoization
   1. 하향식 접근
   2. 큰 문제에서 하위 문제를 확인해가며 진행
   3. 처음부터 다 계산하는 것이 아니라, 계산이 필요한 순간에 계산하여 진행

##
### main
- [x] 피보나치
### practice
- [x] 최소한의 연산으로 1 만들기
- [x] 배낭문제

###### 참고: [https://harimms.tistory.com/265](https://harimms.tistory.com/265)