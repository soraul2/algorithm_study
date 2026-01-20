package org.wootae.algorithm.baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 덩치7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        ArrayList<People> peoples = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String input = bf.readLine();
            StringTokenizer st = new StringTokenizer(input, " ");
            // 문제 입력 순서: 몸무게(weight), 키(height)
            // rank는 여기서 초기화하지 않아도, 아래 로직에서 1부터 시작하면 됨
            peoples.add(new People(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // 전체 비교 (Brute Force)
        for(int i = 0; i < N; i++){
            int rank = 1; // 기본 등수는 1등

            for(int j = 0; j < N; j++){
                if(i == j) continue; // 나 자신과는 비교 안 함

                // 조건: j(상대방)가 i(나)보다 덩치가 큰 경우
                if(peoples.get(j).weight > peoples.get(i).weight && peoples.get(j).height > peoples.get(i).height){
                    rank++; // 내 등수는 뒤로 밀려남
                }
            }

            // 한 사람의 비교가 끝날 때마다 바로 출력 (혹은 배열에 담았다 출력)
            System.out.print(rank + " ");
        }
    }

    public static class People {
        int weight; // 몸무게
        int height; // 키
        // rank 변수는 굳이 객체에 저장 안 해도 됨 (출력만 하면 되므로)

        People(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}