class Leetcode1470 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,4,3,2,1};
        int n = 4;
        int[] res = shuffle(nums, n);
        for(Integer cur: res)
            System.out.println(cur);
    }

    public static int[] shuffle(int[] nums, int n) {
        if(nums == null || nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length];
        int cur = 0;
        for(int i = 0; i < n; i ++) {
            res[cur++] = nums[i];
            res[cur++] = nums[i + n];
        }
        return res;
    }
}
