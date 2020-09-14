public class Main11 {
    /*
        输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
    */

    public int NumberOf1(int n) {
        /* 1 = 000000000000000001 */
        int count = 0;          //计数器
        for (int i = 0; i < 32; i++) {
            if ((n&1)==1){
                count++;
            }
            n = n>>1 ; //每右移一位，就可以算一位是否为1
        }
        return count;
    }
}
