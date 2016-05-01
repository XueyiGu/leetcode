public class NumArray {
int[] st;
int[] input;

int n = 0;
    public NumArray(int[] nums) {
        n = nums.length;
        input = nums;
        if(n == 0){
            return;
        }
        int height = (int)Math.ceil(Math.log(n) / Math.log(2));
        int total = 2 * (int)Math.pow(2, height) - 1;
        st = new int[total];
        construct(nums, 0, n - 1, 0);
    }
    
    private int construct(int[] arr, int ss, int se, int si){
        if(ss == se){
            st[si] = arr[ss];
            return st[si];
        }
        
        int mid = ss + (se - ss) / 2;
        st[si] = construct(arr, ss, mid, si * 2 + 1) +
                 construct(arr, mid + 1, se, si * 2 + 2);
        return st[si];
    }

    void update(int i, int val) {
        if(i < 0 || i >= n){
            return;
        }
        
        int diff = val - input[i];
        input[i] = val;
        updateValue(0, n - 1, i, diff, 0);
    }
    
    private void updateValue(int ss, int se, int i, int diff, int si){
        if(i < ss || i > se){
            return;
        }
        st[si] = st[si] + diff;
        if(se != ss){
            int mid = ss + (se - ss) / 2;
            updateValue(ss, mid, i, diff, si * 2 + 1);
            updateValue(mid + 1, se, i, diff, si * 2 + 2);
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j >= n || i > j){
            return -1;
        }
        
        return getSum(0, n - 1, i, j, 0);
    }
    
    private int getSum(int ss, int se, int qs, int qe, int si){
        if(qs <= ss && qe >= se){
            return st[si];
        }
        if(qs > se || qe < ss){
            return 0;
        }
        int mid = ss + (se - ss) / 2;
        return getSum(ss, mid, qs, qe, si * 2 + 1) +
                getSum(mid + 1, se, qs, qe, si * 2 + 2);
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);