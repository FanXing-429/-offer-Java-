public class Main9 {
    /*
          一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
          求该青蛙跳上一个n级的台阶总共有多少种跳法。
     */
    public int JumpFloorII(int target) {
        /* 采用递推法，递归时间复杂度太高了 */
        //第n个台阶的跳法 == 第1个台阶的跳法 + 第2个台阶的跳法 + ... + 第n-1个台阶的跳法 + 1（直接跳n个 ）
        if (target == 1) {
            return 1;
        }
        //创建一个数组来维护算过的值，避免重复计算
        int[] a = new int[target+1];
        a[1] = 1;
        int sum = 1;
        for (int i = 2; i <= target; i++) {
            a[i] = sum + 1;
            sum = sum + a[i];           //记得更换sum
        }
        return a[target];
    }

}
