package org.wootae.algorithm.baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기적의매매법20546 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        // 1. 초기 자본금 입력
        int cash = Integer.parseInt(bf.readLine());

        // 2. 주가 배열 입력 (14일)
        int[] stockPrices = new int[14];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 14; i++) {
            stockPrices[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 준현(BNP)의 결과 계산
        int jResult = calculateBNP(cash, stockPrices);

        // 4. 성민(TIMING)의 결과 계산
        int sResult = calculateTIMING(cash, stockPrices);

        // 5. 결과 비교 및 출력
        if (jResult > sResult) {
            System.out.println("BNP");
        } else if (jResult < sResult) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    // 준현(BNP) 전략
    // 살 수 있으면 무조건 산다. (매도는 안 함)
    private static int calculateBNP(int cash, int[] prices) {
        int money = cash;
        int stockCount = 0;

        for (int price : prices) {
            if (money >= price) {
                // 매수 가능한 만큼 전량 매수
                stockCount += money / price;
                money %= price; // 남은 돈
            }
        }
        // 최종 자산 = 남은 현금 + (보유 주식 * 마지막 날 주가)
        return money + (stockCount * prices[13]);
    }

    // 성민(TIMING) 전략
    // 3일 연속 상승 -> 전량 매도 / 3일 연속 하락 -> 전량 매수
    private static int calculateTIMING(int cash, int[] prices) {
        int money = cash;
        int stockCount = 0;

        // 3일 연속 비교를 위해 인덱스 3부터 시작 (0,1,2일차 데이터 필요)
        for (int i = 3; i < 14; i++) {

            // 3일 연속 상승 (전량 매도)
            // (3일전 < 2일전) AND (2일전 < 1일전) -> 오늘 다 판다
            if (prices[i - 3] < prices[i - 2] && prices[i - 2] < prices[i - 1]) {
                if (stockCount > 0) {
                    money += stockCount * prices[i];
                    stockCount = 0;
                }
            }

            // 3일 연속 하락 (전량 매수)
            // (3일전 > 2일전) AND (2일전 > 1일전) -> 오늘 다 산다
            else if (prices[i - 3] > prices[i - 2] && prices[i - 2] > prices[i - 1]) {
                if (money >= prices[i]) {
                    stockCount += money / prices[i];
                    money %= prices[i];
                }
            }
        }

        return money + (stockCount * prices[13]);
    }
}