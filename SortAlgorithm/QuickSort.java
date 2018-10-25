public class Main {

    public static void main(String[] args) {
        int[] nums = {9, 5 , 7, 15, 6, 2};
        quick_sort(nums, 0, nums.length - 1);
        for(Integer cur : nums)
            System.out.println(cur);
    }
    public static void quick_sort(int[] nums, int left, int right) {
        if (nums == null || nums.length <= 1 || left >= right)
            return;
        int head = left, tail = right;
      /* 1. 找pivot -> 2. 找到该pivot在数组的最终位置 -> 3.递归至子数组，子问题解决大问题
         这个pivot是随意的，可以是最左边的数，或者最右边的数。或者任何数字
         无论pivot是哪个数字，本质都是递归思想，把全部数组转换成左右两个子数组
         找到个pivot在数组中的最终的位置，左边的数字是比它小的全部数字，但是顺序随机，右边是比它大的，顺序未知
         需要用到双指针的思想
         一左一右，双指针
         假设我们选取的最右数字作为pivot
         （1）首先从左到右找到第一个比pivot大的数字，并且放到右指针的位置，右指针-1
          (2)之后从右到左找到第一个比pivot小的数字，并且放到左指针的位置，左指针+ 1
          （3）继续下次循环，知道左右指针相遇
          （4）把pivot放到右指针的位置，因为此时右指针的右边都是比pivot大的数字
          （5）进入递归
          
          
       */
        int pivot = nums[right];
        while (head < tail) {
            while (head < tail) {
                if (nums[head] < pivot)
                    head++;
                else
                    break;
            }
            if (head < tail)
                nums[tail--] = nums[head];
            while (head < tail) {
                if (nums[tail] > pivot)
                    tail--;
                else
                    break;
            }
            if (head < tail)
                nums[head++] = nums[tail];

        }
            nums[tail] = pivot;
            quick_sort(nums, left, head - 1);
            quick_sort(nums, head + 1, right);

    }
}


