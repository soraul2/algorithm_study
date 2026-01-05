package org.wootae.algorithm.baekjoon.완전탐색;

import java.util.Scanner;

public class Main_19532 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력: 1 3 -1 4 1 7
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (a * x + b * y == c && d * x + e * y == f) {
                    // 주의: x와 y 사이에 반드시 큰따옴표 공백(" ")을 더해줘야 합니다.
                    System.out.println(x + " " + y);
                    return;
                }
            }
        }
        sc.close();
    }
}