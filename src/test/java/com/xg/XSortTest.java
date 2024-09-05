package com.xg;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class XSortTest {

    @Test
    public void bubbleSortTest() {

        //1.  nextInt(max - min + 1)  会生成一个范围在  [0  到  max - min) 之间的随机整数。
        //2. 加上  min  后，随机数的范围就变成了  [min, max] 。

//        int[] arr = new int[]{1, 9, 3, 5, 4, 6, 7, 8, 2, 1};
        int min = 1;
        int max = 10;
        int[] arr = new int[10];
        Random rand = new Random();
        for(int i = 0; i < 10; i++){
            arr[i] = rand.nextInt(max-min+1) + min;
        }
        System.out.println("随机输入: " + arr.toString());
        for(int i = 0; i < 10; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");


        //交换暂存变量
        int temp;

        //外层循环决定执行几轮(n-1)内层循环(以及每层循环的长度变化),[(最后仅仅剩下一个元素不需交换)]
        //未排序区间[0, out]
        for (int out = arr.length-1; out > 0; out--){
           //内层循环[将未排序区间[0,i]中的最大元素交换至该区间的最右端]
           for (int in = 0; in < out; in++){
               //swap(左元素 > 右元素)
               if(arr[in] > arr[in+1]){

                   temp = arr[in];
                   arr[in] = arr[in+1];
                   arr[in+1] = temp;
               }
           }
        }

        System.out.println("冒泡输出: " + arr.toString());
        for(int i = 0; i < 10; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
