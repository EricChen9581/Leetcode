class Solution {
    public int lengthOfLongestSubstring(String s) {
        // LC 3 , 159, 340
        if(s == null)
            return 0;
        if(s.length() == 0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;
        while(right < s.length()) {
            if(!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                res = Math.max(res, right - left + 1);
                right ++;
                continue;
            } else {
                while(left <= right) {
                    if(s.charAt(left) != s.charAt(right)) {
                        set.remove(s.charAt(left));
                        left ++;
                    } else {
                        left ++;
                        res = Math.max(res, right - left + 1);
                        break;
                    }
                }
                right ++;
            }
        }
        return res;
    }
}
