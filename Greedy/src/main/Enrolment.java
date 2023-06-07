package main;/*
    main.Activity Selection Problem: 수강신청
 */

import java.util.ArrayList;
import java.util.Collections;

class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class Enrolment {
    public static void selectActivity(ArrayList<Activity> list) {
        // 종료 시간 기준으로 오름차순
        Collections.sort(list, (x1, x2) -> x1.end - x2. end);

        int curTime = 0;
        ArrayList<Activity> result = new ArrayList<>();
        for (Activity a : list) {
            if (curTime <= a.start) {
                curTime = a.end;
                result.add(a);
            }
        }

        result.stream().forEach(x -> System.out.print(x.name + "\t"));
    }

    public static void main(String[] args) {
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A", 1, 5));
        list.add(new Activity("B", 4, 5));
        list.add(new Activity("C", 2, 3));
        list.add(new Activity("D", 4, 7));
        list.add(new Activity("E", 6, 10));
        selectActivity(list);
    }
}