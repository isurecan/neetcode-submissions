class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Build frequency map
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Buckets where index = frequency
        List<Integer>[] bucket = new List[nums.length + 1];

        // Place numbers into buckets
        for (int key : freqMap.keySet()) {

            int freq = freqMap.get(key);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(key);
        }

        // Collect top k frequent elements
        int[] res = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0; i--) {

            if (bucket[i] != null) {

                for (int num : bucket[i]) {

                    res[index++] = num;

                    if (index == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }
}
