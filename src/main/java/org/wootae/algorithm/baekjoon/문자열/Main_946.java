package org.wootae.algorithm.baekjoon.문자열;

//문제 946 복호화
import java.util.Scanner;

public class Main_946 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 정수 입력 후 남은 엔터 처리를 위해 nextLine() 한 번 호출 필요할 수 있음
        // 혹은 그냥 nextLine으로 숫자를 받아서 파싱하는 것이 안전
        int T = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < T; i++) {
            String line = scanner.nextLine();
            int[] counts = new int[26]; // a-z 빈도수 저장

            // 1. 빈도수 세기
            for (char c : line.toCharArray()) {
                if (c >= 'a' && c <= 'z') { // 소문자만 카운트
                    counts[c - 'a']++;
                }
            }

            // 2. 최대값 찾기
            int max = -1;
            char answer = '?';

            for (int j = 0; j < 26; j++) {
                if (counts[j] > max) {
                    max = counts[j];
                    answer = (char) (j + 'a'); // 현재 문자를 정답 후보로
                } else if (counts[j] == max) {
                    answer = '?'; // 최대값이 같으면 물음표
                }
            }

            System.out.println(answer);
        }
    }
}
/*
* 3
asvdge ef ofmdofn
xvssc kxvbv
hull full suua pmlu
* */

/*
* f
v
?
* */