package org.wootae.algorithm.baekjoon;

import java.util.Scanner;

public class Recorsivecall {

    public static void main(String[] args) {

        Scanner  sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int sum = 0;

        sum = recursive(n);


        System.out.println(sum);
    }


    public static int recursive(int n){
        if(n <= 1){
            return 1;
        }
        System.out.println("recursive "+n);

        return n*recursive(n-1);
    }

}
