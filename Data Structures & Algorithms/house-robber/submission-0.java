class Solution {
    public int rob(int[] nums) {
        //since nums>=1
        if(nums.length<2)
        return nums[0];

        int[] maxrob=new int[nums.length];
        maxrob[0]=nums[0];
        maxrob[1]=Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            int robsCurrent=nums[i]+maxrob[i-2];
            int dosentRobCurrent=maxrob[i-1];
            maxrob[i]=Math.max(robsCurrent,dosentRobCurrent);
        }
        return maxrob[nums.length-1];
    }
}
