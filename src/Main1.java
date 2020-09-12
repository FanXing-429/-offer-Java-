public class Main1 {
    /*在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
     判断数组中是否含有该整数*/

    public boolean Find(int target, int [][] array) {
        /*暴力法：遍历二维数组*/
        int row = array.length;
        int col = array[0].length;
        //遍历二维数组
        for(int i = 0; i < row ; i++){
            for(int j = 0; j < col ;j++){
                //找到了就返回 true
                if(array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean Find1(int target, int [][] array) {
        /*通过递增来解决*/
        int row = array.length;
        int col = array[0].length;
        if (row == 0 || col == 0){
            return false;
        }

        //初始数组左上角的坐标
        int i = 0;
        int j = array[0].length - 1;

        //将数的坐标限制在二维数组中
        while (i >= 0 && i < array.length && j >= 0 && j < array[0].length){
             if (array[i][j] == target){
                 return true;
             }else if (array[i][j] < target){
                 i++;
             }else{
                 j--;
             }
        }
        return false;
    }

}


//题目
//1 2 3
//4 5 6
//7 8 9