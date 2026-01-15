package org.wootae.algorithm.baekjoon.누적합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이차원배열의합2167 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 입력을 받음과 동시에 누적 합 배열 생성
        // (문제의 인덱스가 1부터 시작하므로 크기를 N+1, M+1로 잡음)
        int[][] arr = new int[N + 1][M + 1];
        int[][] prefixSum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 누적 합 공식: 위쪽 + 왼쪽 - 대각선(중복제거) + 자기자신
                prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + arr[i][j];
            }
        }

        int K = Integer.parseInt(br.readLine()); // 합을 구할 횟수

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 2. 구간 합 공식 사용 (반복문 없이 O(1)로 해결)
            // 전체 큰 사각형 - 위쪽 빼기 - 왼쪽 빼기 + 두 번 뺀 부분 더하기
            int result = prefixSum[x][y] - prefixSum[i - 1][y] - prefixSum[x][j - 1] + prefixSum[i - 1][j - 1];

            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }
}