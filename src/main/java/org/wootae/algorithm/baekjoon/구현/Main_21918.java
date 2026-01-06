package org.wootae.algorithm.baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_21918 {

    public static void main(String[] args) throws IOException {
        // Scanner보다 빠른 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. N(전구 개수), M(명령어 개수) 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 전구 초기 상태 입력
        int[] lights = new int[N];
        st = new StringTokenizer(br.readLine()); // 두 번째 줄 읽기
        for (int i = 0; i < N; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 명령어 M번 수행
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 문제의 "1번째"는 배열의 "0번 인덱스"이므로 -1 처리가 필요함
            // 범위 명령어(2,3,4번)의 경우 a번째부터 b번째까지 -> 인덱스는 a-1 부터 b-1 까지

            switch (command) {
                case 1:
                    // a번째 전구의 상태를 b로 변경
                    lights[a - 1] = b;
                    break;
                case 2:
                    // a번째부터 b번째까지 토글 (0->1, 1->0)
                    for (int k = a - 1; k < b; k++) { // k <= b-1 과 같음 (k < b)
                        lights[k] = (lights[k] == 0) ? 1 : 0;
                    }
                    break;
                case 3:
                    // a번째부터 b번째까지 끔(0)
                    for (int k = a - 1; k < b; k++) {
                        lights[k] = 0;
                    }
                    break; // break 필수!
                case 4:
                    // a번째부터 b번째까지 킴(1)
                    for (int k = a - 1; k < b; k++) {
                        lights[k] = 1; // 켜는 거니까 1
                    }
                    break;
            }
        }

        // 4. 출력
        StringBuilder sb = new StringBuilder();
        for (int light : lights) { // 향상된 for문 문법 (: 사용)
            sb.append(light).append(" ");
        }
        System.out.println(sb);
    }
}