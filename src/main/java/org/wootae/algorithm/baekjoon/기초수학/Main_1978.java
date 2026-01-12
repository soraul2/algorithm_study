package org.wootae.algorithm.baekjoon.기초수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1978 {

    /*
    * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
        입력
        첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

        출력
        주어진 수들 중 소수의 개수를 출력한다.

        예제 입력 1
        4
        1 3 5 7
        예제 출력 1
        3
    * */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int odd = 0;
        int N = Integer.parseInt(br.readLine());
        String arr = br.readLine();

        StringTokenizer st = new StringTokenizer(arr);

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) continue; // 1은 소수가 아니므로 다음 숫자로 패스!

            boolean isPrime = true; // 소수라고 가정하고 시작

            // 2부터 num-1까지 나누어 떨어지는지 확인
            for (int j = 2; j < num; j++) {
                if (num % j == 0) { // 나누어 떨어지는 수가 있으면
                    isPrime = false; // 소수가 아님!
                    break;
                }
            }

            if (isPrime) {
                odd++; // 소수일 때만 카운트 증가
            }
        }
        System.out.println(odd);
    }//main
}
