package com.company;
import java.util.Arrays;
public class selectionSort {

    public static void main(String[] args) {
	// write your code her
        int[] number = {1,5, 4 , 20, -1};
        Arrays.sort(number);
        for(Integer cur : number)
        System.out.println(cur);
     }
     public static void sorts(int[] nums){
        if(nums == null || nums.length <= 1)
            return;
       for(int i = nums.length - 1; i > 0; i --) {
           int maxIndex = 0;
           for (int j = 0; j <= i; j++) {
               if (nums[j] > nums[maxIndex]) {
                   maxIndex = Math.max(j, maxIndex);
               }
           }
           swap(nums, i, maxIndex);
       }
     }
     public static void swap(int[] nums, int i, int maxIndex){
        int tmp = nums[i];
        nums[i] = nums[maxIndex];
        nums[maxIndex] = tmp;
     }
}

