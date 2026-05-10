class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
                for (int n : nums) {
                            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
                                    }

                                            List<Integer>[] bucket = new List[nums.length + 1];
                                                    for (int key : countMap.keySet()) {
                                                                int freq = countMap.get(key);
                                                                            if (bucket[freq] == null) {
                                                                                            bucket[freq] = new ArrayList<>();
                                                                                                        }
                                                                                                                    bucket[freq].add(key);
                                                                                                                            }

                                                                                                                                    int[] res = new int[k];
                                                                                                                                            int counter = 0;
                                                                                                                                                    for (int pos = bucket.length - 1; pos >= 0; pos--) {
                                                                                                                                                                if (bucket[pos] != null) {
                                                                                                                                                                                for (int num : bucket[pos]) {
                                                                                                                                                                                                    res[counter++] = num;
                                                                                                                                                                                                                        if (counter == k) return res;
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                    return res;
    }
    }

