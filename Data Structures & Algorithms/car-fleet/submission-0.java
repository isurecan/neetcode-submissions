class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] combine=new int[position.length][2];
        Stack<Double> stack=new Stack<>();

        //lets combine position and speed and keep it in a 2D arrayabstract

        for(int i=0; i<position.length; i++){
            combine[i][0]=position[i];
            combine[i][1]=speed[i];
        }

        //sorting this array based on position
        //to find the car closest to target

        Arrays.sort(combine, java.util.Comparator.comparingInt(o->o[0]));

        for(int i=position.length-1; i>=0; i--){
            //traversing from last as array is sorted in ascending
            //so closest car to the target would be at the last of the array
            double currentTime=(double) (target-combine[i][0])/combine[i][1];
            if(!stack.isEmpty() && currentTime<=stack.peek()){
                //this means the car is faster 
                //so it merges to the previous fleet 
                continue;
            }
            else
            //stack store the distinct values hence gives the fleet count
            stack.push(currentTime);
        }

        return stack.size();
    }
}
