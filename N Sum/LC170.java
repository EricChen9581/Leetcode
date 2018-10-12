class TwoSum {

    /** Initialize your data structure here. */
    HashMap<Integer, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.getOrDefault(number, 0) + 1);
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Integer cur : list){
            int t = value - cur;
            if(t == cur){
                if(map.get(t) >= 2)
                    return true;
                else 
                    continue;
            }
            if(map.containsKey(t))
                return true;
        }
        return false;
    }
}

