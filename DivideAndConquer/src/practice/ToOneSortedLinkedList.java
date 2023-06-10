package practice;

/*
    Practice 2
    2차원 정수형 배열 lists가 주어짐.
    lists[i]에는 각 링크드 리스트의 원소 정보가 들어 있고, 원소들은 오름차순 정렬된 상태.
    모든 링크드 리스트를 하나의 정렬된 링크드 리스트로 합병

    ex)
    lists: {{2,3,9}, {1,5,7}, {3,6,7,11}}
    output: 1->2->3->3->5->6->7->7->9->11
 */

/*
    가능 풀이
    1. 합병 정렬(재귀 호출)
    : 두 개의 node씩 비교하여 합병 반복
 */

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ToOneSortedLinkedList {
    public static Node solution(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return divideList(lists, 0, lists.length - 1);
    }

    public static Node divideList(Node[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }

        // divide
        int mid = left + (right - left) / 2;
        Node l1 = divideList(lists, left, mid);
        Node l2 = divideList(lists, mid+1, right);

        // 분할된 부분들을 합친 것을 리턴
        return mergeList(l1, l2);
    }

    public static Node mergeList(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Node merge = new Node(0);       // merge는 첫번째 원소 가리킴
        Node cur = merge;                   // cur은 merge를 가리키고 이것으로 합병함

        while (l1 != null && l2 != null) {  // 둘다 or 둘 중 하나가 null이 될 때까지 합치기 반복
            if (l1.val < l2.val) {          // l1값 < l2값이면, l1값 추가
                cur.next = l1;
                l1 = l1.next;
            } else {                        // l1값 > l2값이면, l2값 추가
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        // 둘의 길이가 다를 경우 합병하지 못한 남은 값들 추가
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
            cur.next = l2;
        }

        return merge.next;
    }

    // 문제에 주어진 2차원 배열을 링크드 리스트로 구성
    public static void setUpLinkedList(Node[] node, int[][] lists) {
        // 3개의 연결리스트의 첫 원소들을 각 연결리스트의 첫 번째로 두기
        for (int i = 0; i < lists.length; i++) {
            node[i] = new Node(lists[i][0]);
        }
        // 3개의 각각 남은 원소들을 링크드 리스트에 연결시키기
        for (int i = 0; i < lists.length; i++) {
            Node cur = node[i];
            for (int j = 1; j < lists[i].length; j++) {
                cur.next = new Node(lists[i][j]);
                cur = cur.next;
            }
        }
    }

    // 결과 출력
    public static void printList(Node node) {
        Node cur = node;
        while (cur.next != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public static void main(String[] args) {
        int[][] lists = {{2,3,9}, {1,5,7}, {3,6,7,11}};
        Node[] node = new Node[lists.length];
        setUpLinkedList(node, lists);
        Node combinedNode = solution(node);
        printList(combinedNode);
    }
}
