package org.wootae.algorithm.baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class 카드2164 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new ArrayDeque<>();

        //Queue 는 Inteface , ArrayDeque는 Queue를 상속받은 객체
        //ArrayDeque를 그대로 사용해도 되지만 ArrayDeque에 있는 함수를 쓰는 것이 없기 때문에 Queue에 있는 poll(Deque) , offer(enque) 를 사용한다.

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());


    }

}
