class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);

        int[] robsFirstHouse = new int[nums.length-1];
        int[] robsLastHouse = new int[nums.length-1];

        for(int i=0; i<nums.length-1; i++){
            robsFirstHouse[i]=nums[i];
            robsLastHouse[i]=nums[i+1];
        }
       return Math.max(robhouse(robsFirstHouse),
                       robhouse(robsLastHouse));
    }

    public int robhouse(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i=2; i<nums.length; i++){
            int robsCurrent=dp[i-2]+nums[i];
            int dosentRobCurrent=dp[i-1];
            dp[i]=Math.max(robsCurrent,dosentRobCurrent);
        }
        return dp[nums.length-1];
    }
}
