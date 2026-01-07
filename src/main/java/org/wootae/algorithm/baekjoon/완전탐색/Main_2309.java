package org.wootae.algorithm.baekjoon.완전탐색;

/*
* 왕비를 피해 일곱 난쟁이들과 함께 평화롭게 생활하고 있던 백설공주에게 위기가 찾아왔다. 일과를 마치고 돌아온 난쟁이가 일곱 명이 아닌 아홉 명이었던 것이다.

아홉 명의 난쟁이는 모두 자신이 "백설 공주와 일곱 난쟁이"의 주인공이라고 주장했다. 뛰어난 수학적 직관력을 가지고 있던 백설공주는, 다행스럽게도 일곱 난쟁이의 키의 합이 100이 됨을 기억해 냈다.

아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.

입력
아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며, 아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.

출력
일곱 난쟁이의 키를 오름차순으로 출력한다. 일곱 난쟁이를 찾을 수 없는 경우는 없다.
* */

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] peoples = new int[9];
        int[] answer_peoples = new int[7];
        int totalValue = 0;

        //1. 데이터 입력
        for(int i = 0 ; i < peoples.length ; i++){
            peoples[i] = Integer.parseInt(scanner.nextLine());
            totalValue += peoples[i];
        }

        //2. 토탈 100을 뺀 나머지 값
        int minusValue = totalValue - 100;

        int targetPeopleIndex1 = 0;
        int targetPeopleIndex2 = 0;

        boolean found = false;

        //3. 나머지 두개의 합에 대한 모든 경우의 수 체크
        for(int i=0;i<peoples.length;i++){
            for(int j=0;j<peoples.length;j++){
                if(peoples[i]+peoples[j] == minusValue){
                    if(i != j){
                        targetPeopleIndex1 = i;
                        targetPeopleIndex2 = j;
                        found = true;
                        break;
                    }
                }
            }
            if(found){
                break;
            }
        }//for

        //4. 모든 경우의 수에서 true가 나올 경우 해당 인덱스를 제외한 나머지 인덱스 출력
        int sequence = 0;
        for(int i=0;i<peoples.length;i++){
            if(i != targetPeopleIndex1 && i != targetPeopleIndex2){
                answer_peoples[sequence] = peoples[i];
                sequence++;
            }
        }

        Arrays.sort(answer_peoples);

        for(int height : answer_peoples){
            System.out.println(height);
        }

    }


}
