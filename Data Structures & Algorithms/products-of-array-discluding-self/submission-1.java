class Solution {
    public int[] productExceptSelf(int[] nums) {
        //product at i=product of everything to the left of i*product of everything to the right of i

        int[] output=new int[nums.length];

        //build prefix arr
        //keep storing prefix product value
        int prefix=1;
        for(int i=0; i<nums.length; i++){
            output[i]=prefix;
            prefix*=nums[i];
        }

       //build postfix arr
       //output=prefix*ppostfix
       int postfix=1;
       for(int i=nums.length-1; i>=0; i--){
        output[i]*=postfix;
        postfix*=nums[i];
       }

        return output;
    }
}  
