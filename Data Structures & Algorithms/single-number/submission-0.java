class Solution {
    public int singleNumber(int[] nums) {
        int onlyOnce=0;
       for(int i=0; i<nums.length; i++){
        onlyOnce=onlyOnce^nums[i];
       }
        return onlyOnce;
    }
}
