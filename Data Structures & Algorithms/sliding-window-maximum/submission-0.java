class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> deque=new ArrayDeque<>();
        int[] result=new int[n-k+1];


        //build for the first k elements
        for(int i=0; i<k; i++){
            while(!deque.isEmpty() 
            && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        //the 1st element will always contain the *index* of max
        result[0]=nums[deque.peekFirst()];

        for(int i=k; i<n; i++){
            //i represents right pointer
            //so new left pointer become i-k
            if(deque.peekFirst()<=i-k)
            deque.pollFirst();

            while(!deque.isEmpty() 
            && nums[deque.peekLast()]<=nums[i])
            deque.pollLast();

            deque.offerLast(i);

            result[i-k+1]=nums[deque.peekFirst()];
        }

        return result;
    }
}
