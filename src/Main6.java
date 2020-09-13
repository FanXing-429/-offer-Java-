public class Main6 {

    /*
        把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
        例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
        NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
    */
    public static int minNumberInRotateArray(int [] array) {
        //先判断一些特殊情况
        if ( array ==null){
            return -1;
        }
        if (array.length == 0 ){
            return 0;
        }
        int ans = array[0];
        //暴力解法
        //直接进行比较，将数组中的最小值取出来
        for (int i = 1; i < array.length; i++) {
            ans = Math.min(ans, array[i]);
        }
        return ans;
    }


    public static int minNumberInRotateArray0(int [] array) {
        //先判断一些特殊情况
        if ( array ==null){
            return -1;
        }
        if (array.length == 0 ){
            return 0;
        }
        int ans = array[0];
        //通过二分查找的方法
        int left = 0;                       //左指针
        int right = array.length-1;         //右指针
        //二分查找的终结条件
        while (left < right){
            int mid = (left + right) >> 1;  //中间的指针
            if (array[left] <= array[mid]) {  //则此时mid所在的数组为，第一组递增的数组
                //我们知道，最小的数在第二个小数组中
                //此时，我们可以直接跳过mid前面的所有数
                left = mid;
            }
            if (array[mid] < array[right]) { //如果，中间的值小于右边的值，说明最小值一定在此时中间值的左边（包含中间值）
                right = mid;//将左边的值去掉
            }
            while (left == right) {
                ans = array[left];
            }
        }
        return ans;
    }



//    public static int minNumberInRotateArray(int [] array) {
//    //先判断一些特殊情况
//        if ( array ==null){
//        return -1;
//    }
//        if (array.length == 0 ){
//        return 0;
//    }
//    // int ans = array[0];
//    //通过二分查找的方法
//    int left = 0;                       //左指针
//    int right = array.length-1;         //右指针
//    //二分查找的终结条件
//        while (left < right){
//        int mid = (left + right) >> 1;  //中间的指针
//        if (array[left] <= array[mid]) {  //则此时mid所在的数组为，第一组递增的数组
//            //我们知道，最小的数在第二个小数组中
//            //此时，我们可以直接跳过mid前面的所有数
//            left = mid;
//        }
//        if (array[mid] <= array[right]) { //如果，中间的值小于右边的值，说明最小值一定在此时中间值的左边（包含中间值）
//            right = mid;//将左边的值去掉
//        }
//        //if (left == right) {
//        //     return array[left];
//        // }
//    }
//        return array[left];
//    // return ans;
//}



    public int minNumberInRotateArray1(int [] array) {
        //先判断一些特殊情况
        if ( array ==null){
            return -1;
        }
        if (array.length == 0 ){
            return 0;
        }
        int ans = array[0];
        //二分查找法
        //原先没有旋转的时候，最小的值在最开始，经过旋转，现在最小的值就在中间
        //我们通过二分查找在中间寻找最小的值
        //在数组旋转之后，原先一个的有序数组就变为了两个有序数组，并且我们知道：
        //后面的有序数组的最大值（array[end]）也是小于等于前面数组的最小值(array[start])
        //定义头指针和尾指针和中间指针
        int start = 0;
        int end = array.length-1;
        int mid = (start+end)>>1;//除2
        //一般情况下，我们左边开始的小数组中一定是没有最小值的，那么我们必须要快速跳出前面的小数组
        ///这种方法超时了
        while (end > start){//限制范围
            //3 4 5 【6】 7 0 1 2
            if (array[mid] > array[end]) {
                mid++;
                while (array[mid] < array[end]){
                    ans = array[mid];
                }
            }
            //5 6 0 [1] 2 3 4
            if (array[mid] < array[end]) {
                mid--;
                while (array[mid] > array[end]){
                    ans =  array[mid+1];
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {3,4,5,6,7,8};
        int[] array1 = {5,6,7,8,9,0,1,2,3,4};
        System.out.println(minNumberInRotateArray(array));
        System.out.println(minNumberInRotateArray(array1));
    }
}
