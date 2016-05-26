public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        if(total % 2 == 0){
            return (double)(findKth(nums1, 0, m, nums2, 0, n, total / 2) + 
                    findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1)) / 2;
        }else{
            return findKth(nums1, 0, m, nums2, 0, n, total / 2 + 1);
        }
    }
    
    private int findKth(int[] a, int aStart, int m, int[] b, int bStart, int n, int k)
    {
        if(m > n){
            return findKth(b, bStart, n, a, aStart, m, k);
        }
        
        if(m == 0){
            return b[bStart + k - 1];
        }
        
        if(k == 1){
            return Math.min(a[aStart], b[bStart]);
        }
        
        int am = Math.min(k / 2, m);
        int bm = k - am;
        if(a[aStart + am - 1] < b[bStart + bm - 1]){
            return findKth(a, aStart + am, m - am, b, bStart, n, k - am);
        }else if(a[aStart + am - 1] > b[bStart + bm - 1]){
            return findKth(a, aStart, m, b, bStart + bm, n - bm, k - bm);
        }else{
            return a[aStart + am - 1];
        }
        
    }
}