class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap= new HashMap<>();

        for(int n: nums){
            freqMap.put(n, freqMap.getOrDefault(n,0)+1);
        }

        //index represent frequency
        List<Integer>[] bucket =new List[nums.length+1];

        for(int key: freqMap.keySet()){
            if(bucket[freqMap.get(key)]==null){
                bucket[freqMap.get(key)]=new ArrayList<>();
            }
            bucket[freqMap.get(key)].add(key);
        }

        //extract
        int[] topK=new int[k];
        int counter=0;
        for(int i=bucket.length-1; i>=0; i--){
            if(bucket[i]!=null){
                for(int n:bucket[i]){
                    topK[counter]=n;
                    counter++;
                    if(counter==k)
                    return topK;
                }
            }
        }
        return topK;
    }
}
