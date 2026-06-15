class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> encountered=new HashSet<>();

        while(true){

        int sum=0;
        while(n!=0){
            int digit=n%10;
            sum=sum+(int)Math.pow(digit,2);
            n=n/10;
        }
        if(sum==1) return true;

        n=sum;
        if(encountered.contains(n)) return false;
        else 
        encountered.add(n);
    }
    }
}

