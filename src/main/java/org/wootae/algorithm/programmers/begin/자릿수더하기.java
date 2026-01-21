package org.wootae.algorithm.programmers.begin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 자릿수더하기 {


    public static void main(String[] args) throws IOException {

        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        int sum = 0;

        for(char c : input.toCharArray()){
            sum += Integer.parseInt(c+"");
        }

        System.out.println(sum);


    }

}
