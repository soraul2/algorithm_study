package org.wootae.algorithm.baekjoon.누적합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기4 {

    //수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefixList = new int[N + 1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            prefixList[i] = prefixList[i-1] + num;
        }

        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println(prefixList[end] - prefixList[start - 1]);
        }


    }//main

}//class
