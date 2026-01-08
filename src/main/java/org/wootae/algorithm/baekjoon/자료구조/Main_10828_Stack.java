package org.wootae.algorithm.baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10828_Stack {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 클래스 이름은 stackArray지만, 내부는 Node로 동작하는 객체 생성
        stackArray stack = new stackArray();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push")) {
                int value = Integer.parseInt(st.nextToken());
                stack.push(value);
            } else if (command.equals("pop")) {
                sb.append(stack.pop()).append('\n');
            } else if (command.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (command.equals("empty")) {
                sb.append(stack.empty()).append('\n');
            } else if (command.equals("top")) {
                sb.append(stack.top()).append('\n');
            }
        }
        System.out.println(sb);
    }

    // -----------------------------------------------------
    // 요청하신 stackArray 클래스 (내부는 Node 구현)
    // -----------------------------------------------------
    public static class stackArray {

        // 내부에서 사용할 Node 클래스 정의
        private class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        // 스택의 상태를 관리하는 변수들
        private Node top; // 스택의 맨 위(입구)를 가리키는 노드 (Head 역할)
        private int size; // 데이터 개수

        // 생성자
        public stackArray() {
            this.top = null;
            this.size = 0;
        }

        // 1. Push: 새 노드를 만들고 'top' 앞에 붙임 (O(1))
        public void push(int value) {
            Node newNode = new Node(value);
            newNode.next = top; // 새 노드가 기존의 top을 가리키게 함
            top = newNode;      // top을 새 노드로 변경
            size++;
        }

        // 2. Pop: 현재 'top'을 제거하고 그 다음 노드를 top으로 설정 (O(1))
        public int pop() {
            if (empty() == 1) {
                return -1;
            }
            int data = top.data; // 현재 top의 데이터 저장
            top = top.next;      // top을 한 칸 아래(next)로 이동 (삭제 효과)
            size--;
            return data;
        }

        // 3. Size: 개수 반환
        public int size() {
            return size;
        }

        // 4. Empty: 비었는지 확인
        public int empty() {
            return (top == null) ? 1 : 0;
        }

        // 5. Top: 제거하지 않고 값만 확인
        public int top() {
            if (empty() == 1) {
                return -1;
            }
            return top.data;
        }
    }
}

