class Solution {
    public int rob(int[] nums) {

        if(nums.length==1)
       return nums[0];

       int[] maxmoney = new int[nums.length];

        maxmoney[0]=nums[0];
        maxmoney[1]=Math.max(nums[0], nums[1]);

       for(int i=2; i<nums.length; i++){
        int robscurrent=maxmoney[i-2]+nums[i];
        int doesnotrobcurrent=maxmoney[i-1];
        maxmoney[i]=Math.max(robscurrent,doesnotrobcurrent);
       }

       return maxmoney[nums.length-1];

    }
}
