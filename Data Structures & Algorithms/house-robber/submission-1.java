class Solution {
    public int rob(int[] nums) {
        //since nums>=1
        if(nums.length<2)
        return nums[0];

        int[] maxrob=new int[nums.length];
        maxrob[0]=nums[0];
        maxrob[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            //either he robs current house
            int robsCurrent=nums[i]+maxrob[i-2];
            //or he dosent rob current house
            int dosentRobCurrent=maxrob[i-1];
            //find max from the choice
            maxrob[i]=Math.max(robsCurrent,dosentRobCurrent);
        }
        return maxrob[nums.length-1];
    }
}
