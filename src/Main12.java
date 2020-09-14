public class Main12 {
    /*
        给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
        保证base和exponent不同时为0
     */

    /* 这道题，需要分类讨论,exponent是大于0还是小于0 */
    public double Power(double base, int exponent) {
        if (base == 0.0){
            return 0.0;
        }
        double result = 1.0;
        //取绝对值，确定循环次数
        int e = exponent > 0 ? exponent : -exponent;
        for (int i = 1; i <= e; i++) {
            result = result * base;
        }
        return exponent > 0 ? result : 1/result;
    }
}
