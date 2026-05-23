class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        Stack<Integer> stack=new Stack<>();
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        int maxArea=0;

            for(int i=0; i<n; i++){
                while(!stack.isEmpty() &&
                heights[i]<=heights[stack.peek()]){
                    int prevsmall=stack.pop();
                    right[prevsmall]=i;
                }
                stack.push(i);
            }

        stack.clear();

               for(int i=n-1; i>=0; i--){
                while(!stack.isEmpty() &&
                heights[i]<heights[stack.peek()]){
                    int prevsmall=stack.pop();
                    left[prevsmall]=i;
                }
                stack.push(i);
            }

            for(int i=0; i<n; i++){
                int area=heights[i]*
                (right[i]-left[i]-1); //area is between them not including them
                maxArea=Math.max(area, maxArea);
            }

            return maxArea;

    }
}
