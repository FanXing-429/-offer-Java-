public class Main10 {
    /*
        我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
        请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
        比如n=3时，2*3的矩形块有3种覆盖方法：
    */

    public int RectCover(int target) {
        /* 上面的递归的方法，时间复杂度为 O(n^2)，我们可以通过递推的方法来保存所有算过的值
         * 时间复杂度为 O(n)
         *  */
        if (target <= 0){
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        //创建一个数组来存放算过的所有值，用的时候就可以直接调用
        int[] a = new int[target+1];
        //我们已经知道的数组的值
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= target; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[target];
    }
}
