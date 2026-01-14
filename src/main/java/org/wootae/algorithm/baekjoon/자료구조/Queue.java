package org.wootae.algorithm.baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue {

    public static class QueueNode {

        Node last = null;
        Node first = null;
        int size = 0;

        public void push(int data) {

            Node newNode = new Node(data);

            if (size == 0) {
                last = newNode;
                first = newNode;
            } else {
                first.next = newNode;
                first = newNode;
            }
            size++;
        }//push

        public int pop() {

            if (size == 0) return -1;
            int data = last.data;
            last = last.next;
            size--;
            if (size == 0){
                last = null;
                first = null;
            }
            return data;
        }

        public int size() {
            return size;
        }

        public int front() {
            return size == 0 ? -1 : last.data;
        }

        public int back() {
            return size == 0 ? -1 : first.data;
        }
        public int empty() {
            return size == 0 ? 1 : 0;
        }
    }

    public static class Node {

        Node next;
        int data;

        Node(int data) {
            this.next = null;
            this.data = data;
        }
    }

    public static class MainQueue {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            QueueNode queueNode = new QueueNode();
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch (command) {
                    case "push":
                        queueNode.push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop":
                        sb.append(queueNode.pop()).append("\n");
                        break;
                    case "size":
                        sb.append(queueNode.size()).append("\n");
                        break;
                    case "empty":
                        sb.append(queueNode.empty()).append("\n");
                        break;
                    case "front":
                        sb.append(queueNode.front()).append("\n");
                        break;
                    case "back":
                        sb.append(queueNode.back()).append("\n");
                        break;
                }
            }
            System.out.print(sb); // 한 번에 출력하여 시간 단축

        }//main()
    }


}
