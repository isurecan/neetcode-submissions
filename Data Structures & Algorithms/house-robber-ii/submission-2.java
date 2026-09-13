class Solution {
    public int rob(int[] nums) {
        int n=nums.length;

       if(n==1) return nums[0];
       if(n==2) return Math.max(nums[0],nums[1]);

       int[] robsFirstHouse= new int[n-1];
       int[] robsLastHouse= new int[n-1];

       for(int i=0; i<n-1; i++){
        robsFirstHouse[i]=nums[i];
        robsLastHouse[i]=nums[i+1];
       }

       return Math.max(robHouse(robsFirstHouse),
                       robHouse(robsLastHouse));
       }
       
   public int robHouse(int[] nums) {

       if(nums.length==1) return nums[0];

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
