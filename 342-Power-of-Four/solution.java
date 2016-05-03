public class Solution {
    public boolean isPowerOfFour(int num) {
        /**
         * 如果一个数是 2 的次幂，那么我们就可以接着判断这个数是不是 4 的次幂，因为 4 的次幂 1 *所出现的位数一定是在奇数位，因此我们只需要用 01010101010101010101010101010101 （0x55555555）与上这个数，不为 0 *就表示这个数是 4 的幂了，代码如下
         * */
         if(num <= 0){
             return false;
         }
         
         return ((num - 1) & num) == 0 && (0x55555555 & num) != 0;
         
    }
}