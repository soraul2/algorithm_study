package org.wootae.algorithm.baekjoon.문자열;

import java.util.Scanner;

class Main_11720 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        //1. 몇개의 숫자를 넣을 것인가?
        int n = scan.nextInt();
        //2. 어떤 숫자를 넣을 것인가?
        String n_plus = scan.next();//4
        //3. 숫자 입력
        String[] array = new String[n];//1234
        int sum = 0;
        //4. 문자로 받은 숫자를 인덱스 마다 뽑는다.
        for (int i = 0; i < array.length; i++) {
            //4.1 뽑은 숫자(문자)를 문자열로 파싱 한 후에 정수형으로 변환
            array[i] = n_plus.charAt(i) + "";
            //4.2 sum에 합친다.
            sum = sum + Integer.parseInt(array[i]);
        }
        System.out.println(sum);


    }
}
