package org.wootae.algorithm.baekjoon.구현;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class Main_14467_bronze {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // 1. 소를 측정한 횟수 : N
        int N = scanner.nextInt();

        // 2. 소의 번호와 위치를 담을 Map (Key: 소 번호, Value: 위치)
        Map<Integer, Integer> searchCowList = new HashMap<>();

        int sum = 0;

        for(int i = 0 ; i < N ; i ++){
            // 3. 입력 수정

            int cow = scanner.nextInt();   // 소 번호
            int place = scanner.nextInt(); // 소 위치 (0 or 1)

            // map에 소가 있는지 확인
            if(searchCowList.containsKey(cow)){
                // 기존 위치와 다르면 이동한 것이므로 카운트 증가
                if(searchCowList.get(cow) != place){
                    sum++;
                    searchCowList.put(cow, place); // 위치 업데이트
                }
            } else {
                // 처음 관찰된 소라면 맵에 등록
                searchCowList.put(cow, place);
            }
        }

        // 4. 결과 출력
        System.out.println(sum);
    }
}