package org.wootae.algorithm.baekjoon.누적합;

/*
 * n과 xi가 주어짇나. n은 10만 이하ㅇ고, xi는 젗ㄹ댓값이 100이하인 정수디이다.
 */

// 식 풀이

/*
 * 입력 -> 100,000 enter 1 ..... n(100,000)
 *
 * (a1*a2)+(a1*a3)....(a1*a100000)
 * + (a2*a3)+(a2*a4)......(a2*a100000)
 * + (a3*a4)+(a3*a5).........(a3*a100000)
 * + ...........+(a99999*a100000)
 * 모든 경우는 50억 정도 -> 1억 계산 -> 1초 , 총 계산 50초
 * 계산식을 변형하면 a1(a2+a3+a4....a100000) + a2(a3+a4+a5+a6....a100000)......a99999(a100000)
 * a1~an 까지 모든 합을 구하고 그 다음 for문에서 i를 모든 합에서 빼준다
 * an*sum 하면 완료
 * 단 int는 21억 까지 밖에 표현이 되지 않기 때문에 long를 해야하고 double은 소수점이 불안정 하기 때문에 값의 오차가 발생 할 수 있음.
 *
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        long result = 0;

        for (int i = 0; i < N - 1; i++) {
            int current = arr[i];
            sum -= current;
            result += (long) current * sum;
        }

        System.out.println(result);
    }
}
