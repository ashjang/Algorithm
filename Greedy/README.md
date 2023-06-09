# Greedy Algorithm (탐욕)

### : 여러 경우 중 하나를 결정할 때, 그 순간에 최적이라고 생각되는 것을 선택하는 것.

- 빠르게 근사치를 계산 가능
- 결과적(전역적)으로 최적해가 아닐 수도 있음
- 한 번 선택한 선택은 다시 고려X
- _[동적 프로그래밍](https://github.com/ashjang/Algorithm/tree/main/DynamicProgramming)과 달리_ 지역적으로 최선의 선택을 수행하는 방식

#

## 조건
 - **그리디는 빠르지만 최적해를 보장안해도 될 때**
 - **아래의 조건 만족할 때**
- 1. (탐욕적 선택 특성) 지금 선택이 다음 선택에 영향을 주지 않고(현재 상태의 최적해를 추구하고, 다음단계나 전체문제의 해결 방향을 고려X) (ex. 연상: 서울<->부산. 중간에 대전)
- 2. (최적 부분 구조) 전체 문제의 최적해는 부분 문제의 최적해로 이루어짐

    ex) 500원은 5개의 100원으로 구성, 100원은 2개의 50원으로 구성, 50원은 5개의 10원으로 구성되어 있으므로 2번에 해당
    
    ex) 하지만, 만약 400원의 단독 동전이 있다면 400원은 500원을 구성시킬 수 없으므로 2번에 해당하지 않음.


#
### main
- [x] 수강신청
- [x] 거스름돈
### 연습문제
- [x] 첫번째에서 마지막 원소까지 도달 가능여부 판별
- [x] 주식 수익
- [x] 최소 연산으로 1 만들기
- [x] 원형 순환 가능 여부
- [x] <U>**정수의 두자리를 한번의 교체로 최댓값**</U>
#
#


###### 참고: [https://harimms.tistory.com/245](https://harimms.tistory.com/245)
