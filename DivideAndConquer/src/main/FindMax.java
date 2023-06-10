package main;

public class FindMax {
    public static int getMax(int[] arr, int left, int right) {
        // 중앙값
        int m = (left + right) / 2;

        // 탈출 조건
        if (left == right) {
            return arr[left];
        }

        // 좌우분할 하여 또 check
        left = getMax(arr, left, m);
        right = getMax(arr, m + 1, right);

        // 최댓값
        return (left > right) ? left: right;
    }

    public static void main(String[] args) {
        int arr[] = {3,5,10,50,25,30,1,15};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}