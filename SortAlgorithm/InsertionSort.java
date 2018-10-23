package com.company;

import java.util.Arrays;

public class insertionSort {
    public static void main(String[] args) {
        // write your code her
        int[] number = {-1, -1, -9, -1, -9, -1, -9};
        sort(number);
        for(Integer cur : number)
            System.out.println(cur);
    }
    public static void sort(int[] numbers){
        if(numbers == null || numbers.length <= 1)
            return;
        for(int i = 1; i < numbers.length; i ++) {
            int curPivot = numbers[i];
            for(int j = i - 1; j >= 0; j --) {
                if (numbers[j] > curPivot) {
                    numbers[j + 1] = numbers[j];
                    if(j == 0) {
                        numbers[0] = curPivot;
                        break;
                    }
                } else {
                    numbers[j + 1] = curPivot;
                    break;
                }
            }
        }
    }
}
