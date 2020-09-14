import java.util.ArrayList;

public class Main13 {

    /*
          输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
          使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
          并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     */

    /* 通过两个数组【一个数组放偶数，一个数组放奇数】来维护 */
    public void reOrderArray(int [] array) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
                list1.add(array[i]);
            }
            if (array[i] % 2 == 0 ){
                list2.add(array[i]);
            }
        }
        int index = 0;
        for (Integer x : list1) {
            array[index++] = x;
        }
        for (Integer x : list2) {
            array[index++] = x;
        }
    }
}
