class Solution {
    // 回顾经典题
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums == null || nums.length <= 1)
            return res;
        
        for(int i = 0; i < nums.length; i ++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                res[1] = i;
                res[0] = map.get(tmp);
                return res;
            }
            map.put(nums[i], i);
        }
      return new int[]{-1, -1};
    }
}
//sdfasd
