public class Main8 {
    /*
        一只青蛙一次可以跳上1级台阶，也可以跳上2级。
        求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */


    /* 递归的方法 */
    public int JumpFloor(int target) {
        //从第3个台阶开始总结
        //跳上第3个台阶的跳法数 == 跳上第1个台阶的跳法数 + 跳上第2个台阶的跳法数
        final int ONE = 1;        //跳上第一个台阶的跳法数
        final int TWO = 2;        //跳上第二个台阶的跳法数
        if (target == 1) {
            return ONE;
        }
        if (target == 2) {
            return TWO;
        }
        return JumpFloor(target - 1) + JumpFloor(target - 2);

//        int num = 0;
//        while (target >= 3) {  //为什么，这种不行，这是因为死循环了
//            num =  JumpFloor(target-1)+JumpFloor(target-2);
//        }
//        return num;
    }

    /* 递推的方法【大大降低了时间复杂度】 */
    public int JumpFloor1(int target) {
        /* 上面的递归的方法，时间复杂度为 O(n^2)，我们可以通过递推的方法来保存所有算过的值
        * 时间复杂度为 O(n)
        *  */
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
