class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map= new HashMap<>();  
        
        for(String s:strs){
            //build frequency array
            int[] count=new int[26];
            for(char c:s.toCharArray()){
                count[c-'a']++;
            }

            //build key
            StringBuilder sb=new StringBuilder();
            for(int c:count){
                sb.append(c);
                sb.append('#');
            }
            String key=sb.toString();

            //populate map at key
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(s);
        }
        //since map.values() returns Collection<List<String>>
        //so need to wrap it around ArrayList<> 
        return new ArrayList<>(map.values());

    }
}
