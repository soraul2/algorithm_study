package org.wootae.algorithm.baekjoon.문자열;

import java.util.Scanner;

public class Main4659 {

    public static boolean moumCheck(char data) {
        return (data == 'a' || data == 'e' || data == 'i' || data == 'o' || data == 'u') ? true : false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String data = sc.next();
            if (data.equals("end")) break;

            boolean hasVowel = false;    // 모음이 하나라도 있는가?
            boolean isPossible = true;   // 이 단어는 아직 괜찮은가?
            int vCnt = 0; // 연속 모음 카운트
            int cCnt = 0; // 연속 자음 카운트
            char prev = ' '; // 이전 글자를 기억하기 위한 변수

            for (int i = 0; i < data.length(); i++) {
                char curr = data.charAt(i);

                // 1. 모음인지 자음인지 판단하고 카운트 쌓기
                if (moumCheck(curr)) {
                    hasVowel = true;
                    vCnt++;
                    cCnt = 0;
                } else {
                    cCnt++;
                    vCnt = 0;
                }

                // [검문소 1] 3개 연속인가? -> 탈락!
                if (vCnt >= 3 || cCnt >= 3) {
                    isPossible = false;
                    break;
                }

                // [검문소 2] 이전 글자와 같은데 ee, oo가 아닌가? -> 탈락!
                if (i > 0 && curr == prev) {
                    if (!(curr == 'e' || curr == 'o')) {
                        isPossible = false;
                        break;
                    }
                }

                prev = curr; // 다음 글자 체크를 위해 현재 글자를 저장
            }

            // [검문소 3] 다 돌았는데 모음이 하나도 없나? -> 탈락!
            if (!hasVowel) isPossible = false;

            // 결과 출력
            if (isPossible) {
                System.out.println("<" + data + "> is acceptable.");
            } else {
                System.out.println("<" + data + "> is not acceptable.");
            }
        }
    }

}
