class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        

        //sort the array
        Arrays.sort(nums);

        //create a list for storing result
        List<List<Integer>> res=new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            
            //check for(skip) duplicates
            if(i>0 && nums[i]==nums[i-1]) continue;

            //we fix the current number and so the remaining is 2sum problem
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];

                if(sum>0) right--;

                else if(sum<0) left++;

                else {
                
                res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                
                left++;
                right--;

                //we have already incremented left
                while(left<right && nums[left]==nums[left-1]){
                    left++;
                }

                //The code would still work fine if we only check for left duplicates or right duplicates, but checking both helps with logic symmetry
                while(left<right && nums[right]==nums[right+1]){
                    right--;
                }
                }              
            }
        }
        return res;
    }
}
