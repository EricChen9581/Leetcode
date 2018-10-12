//Given array is sorted
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length <= 1)
            return new int[2];
        int[] res = new int[2];
        for(int i = 0; i < numbers.length - 1; i ++) {
            int curTarget = target - numbers[i];
            int find = binarySearch(i, numbers, i + 1, numbers.length - 1, curTarget);
            if( find > i) {
                res[0] = i + 1;
                res[1] = find + 1;
            }
        }
        return res;
    }
    public int binarySearch(int org, int[] numbers, int left, int right, int t) {
        while(left + 1 < right) {
            int mid = left + (right - left)/2;
            if(t < numbers[mid]) {
                right = mid;
            } else if(t > numbers[mid]){
                left = mid;
            } else {
                return mid;
            }
        }
        if(numbers[left] == t)
            return left;
        else if(numbers[right] == t)
            return right;
        return org;
    }
}
