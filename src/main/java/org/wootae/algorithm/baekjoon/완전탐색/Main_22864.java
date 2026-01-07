package org.wootae.algorithm.baekjoon.완전탐색;

/*
* 하루에 한 시간 단위로 일을 하거나 일을 쉬어도 된다. 하루에 한 시간 일하면 피로도는
$A$만큼 쌓이고 일은
$B$만큼 처리할 수 있다.

만약에 한 시간을 쉰다면 피로도는
$C$만큼 줄어든다. 단, 피로도가 음수로 내려가면
$0$으로 바뀐다. 당연히 일을 하지 않고 쉬었기 때문에 처리한 일은 없다.

피로도를 최대한
$M$을 넘지 않게 일을 하려고 한다.
$M$을 넘기면 일하는데 번아웃이 와서 이미 했던 일들도 다 던져버리고 일을 그만두게 된다.

번아웃이 되지 않도록 일을 할때 하루에 최대 얼마나 일을 할 수 있는지 구해보자. 하루는 24시간이다.
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_22864 {

    public static void main(String[] args) throws Exception {
        //일 : 피로도 증가 , 일의 양 증가 , 1 hour +
        //휴식 : 피로도 감소 , 일의 양 변화 없음 ,  1 hour +
        int current_state = 0;
        int work_state = 0;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        // 1. 입력 받기 A 5(일 할때 쌓이는 피로도) B 3(일 하면 생기는 일의 양) C 2(쉴 경우 감소 피로도) D 10(최대 피로도 M)

        int A = Integer.parseInt(st.nextToken()); //(일 할때 쌓이는 피로도)
        int B = Integer.parseInt(st.nextToken()); //(일 하면 생기는 일의 양)
        int C = Integer.parseInt(st.nextToken()); //(쉴 경우 감소 피로도)
        int D = Integer.parseInt(st.nextToken()); //(최대 피로도 M)

        //하루 24시간
        for(int i = 0 ; i < 24 ; i++){

            // 2. 최대 피로도 M에 따른 업무 분담

            if(current_state + A > D){
               current_state -= C;

               if(current_state < 0){
                   current_state = 0;
               }

            }else{
                current_state += A;
                work_state += B;
            }
        }
        // 3. 출력
        System.out.println(work_state);
    }
}



