public class Main7 {
    /*
         大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
        n<=39
    */
    public int Fibonacci(int n) {
        /* 采用递归的方式 */
        //这种方法的时间复杂度为 O(n^2)
        if (n == 0) {
            return 0;           //终止递归的条件
        }
        if (n ==1 || n==2) {
            return 1;           //终止递归的条件
        }

        return  Fibonacci(n-1) + Fibonacci(n-2);
    }


    public int Fibonacci1(int n) {
        /* 新建一个数组将所有的  Fibonacci(n) 存储下来，避免重复运算*/
        //此种方法只适用于n有范围
        //时间复杂度为O(n)
        int[] a = new int[n+1];
        if (n == 0) {
            return 0;
        }
        if (n ==1 || n==2) {
            return 1;
        }

        a[0] = 0;
        a[1] = 1;
        a[2] = 1;
        for (int i = 3; i <= n; i++){
            a[i] = a[i-1] + a[i-2];
        }

        return a[n];
    }
}
