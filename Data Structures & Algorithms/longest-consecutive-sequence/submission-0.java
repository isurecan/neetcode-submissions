class Solution {
    public int longestConsecutive(int[] nums) {
        
      Set<Integer> set=new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int longest=0;

        for(int n:set){

            //if n-1 is present then the number is not the start of a sequence

            if(!set.contains(n-1)){
                int length=0;
                while(set.contains(n+length)){
                    length+=1;
                }
                longest=Math.max(longest,length);
            }
        }
        return longest;  
    }
}
