public class Solution {
    class Number{
        int key;
        int count;
        public Number(int key, int count){
            this.key = key;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i]) + 1);
            }else{
                map.put(nums[i], 1);
            }
        }
        
        Number[] heap = new Number[k];
        int j = 0;
        for(Integer i : map.keySet()){
            if(j < k){
                heap[j] = new Number(i, map.get(i));
                j++;
            }else if(j == k){
                for(int n = k / 2; n > -1; n--){
                    heapify(heap, n);
                }
                
                if(map.get(i) > heap[0].count){
                    heap[0] = new Number(i, map.get(i));
                    heapify(heap, 0);
                }
                j++;
            }else{
                if(map.get(i) > heap[0].count){
                    heap[0] = new Number(i, map.get(i));
                    heapify(heap, 0);
                }
                j++;
            }
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            result.add(heap[i].key);
        }
        return result;
    }
    
    private void heapify(Number[] heap, int i){
        int smallest_index = i;
        if(i * 2 + 1 < heap.length && heap[i * 2 + 1].count < heap[smallest_index].count){
            smallest_index = i * 2 + 1;
        }
        if(i * 2 + 2 < heap.length && heap[i * 2 + 2].count < heap[smallest_index].count){
            smallest_index = i * 2 + 2;
        }
        
        if(smallest_index != i){
            swap(heap, i, smallest_index);
            heapify(heap, smallest_index);
        }
        
    }
    
    private void swap(Number[] heap, int i, int j){
        Number temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}