class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0;

        for(int right=0, left=0; right<s.length(); right++){
            char c=s.charAt(right);
            if(map.containsKey(c) && map.get(c)>=left){
                left=map.get(c)+1;
            }
            maxLength=Math.max(maxLength, right-left+1);
            map.put(c, right);
        }
        
        return maxLength;
    }
}
