package com.company;
import java.util.Arrays;
public class bubbleSort {

    public static void main(String[] args) {
        // write your code her
        int[] number = {1,5, 4 , 20, -1};
        bubblesorts(number);
        for(Integer cur : number)
            System.out.println(cur);
    }
    public static void bubblesorts(int[] numbers){
        if(numbers == null || numbers.length <= 1)
            return;
         for(int i = numbers.length - 1; i >= 0; i --){
             for(int j = 0; j <= i; j ++){
                 if(numbers[i] <= numbers[j])
                     swap(numbers, i, j );
             }
         }
    }
    public static void swap(int[] nums, int i, int maxIndex){
        int tmp = nums[i];
        nums[i] = nums[maxIndex];
        nums[maxIndex] = tmp;
    }
}

