class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        // 1. create a graph using two hashmap
        /*
        (1) hashmap1：  key : string  value: list of strings
        (2) hashmap2: key : string, value : list of values
        */
        HashMap<String, ArrayList<String>> map1 = new HashMap<>();
        HashMap<String, ArrayList<Double>> map2 = new HashMap<>();
        for(int i = 0 ; i < equations.length; i ++) {
            String key1 = equations[i][0];
            String value1 = equations[i][1];
            if(!map1.containsKey(key1)) {
                map1.put(key1, new ArrayList<String>());
                map2.put(key1, new ArrayList<Double>());
            }
            if(!map1.containsKey(value1)) {
                map1.put(value1, new ArrayList<String>());
                map2.put(value1, new ArrayList<Double>());
            }
            map1.get(key1).add(value1);
            map2.get(key1).add(values[i]);
            map1.get(value1).add(key1);
            map2.get(value1).add(1.0/values[i]);
            //return type is double array
            
        }
        double[] res = new double[queries.length];
            for(int i = 0; i < queries.length; i ++){
                HashSet<String> set = new HashSet<>();
                double curNum = dfs(map1, map2, queries[i][0], queries[i][1], 1.0, set);
                if(curNum == 0.0)
                    res[i] = -1.0;
                else 
                    res[i] = curNum;
            }
            return res;
        }
    
        public double dfs(HashMap<String, ArrayList<String>> map1,
                         HashMap<String, ArrayList<Double>> map2,
                         String start, String end,
                         Double curValue, HashSet<String> set) {
            if(set.contains(start))
                return 0.0;
            if(!map1.containsKey(start))
                return 0.0;
            if(start.equals(end))
                return curValue;
            List<String> curListNodes = map1.get(start);
            List<Double> curValueNodes = map2.get(start);
            double tmp = 0.0;
            set.add(start);
            for(int i = 0; i < curListNodes.size(); i ++) {
               // dfs
               tmp = dfs(map1, map2, curListNodes.get(i), end, curValue * curValueNodes.get(i), set);   
              // missing 
                if(tmp != 0.0)
                    return tmp;
            }
            
            set.remove(start);
            return tmp;
        }
    
}
