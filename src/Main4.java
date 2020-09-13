import java.util.Arrays;

public class Main4 {
    /*
    输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
    则重建二叉树并返回。
    */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        //开始先判断一些特殊情况
        if(pre == null || pre.length == 0){
            return null;
        }
        //前序遍历序列   [1] [2 4 7] [3 5 6 8]
        //中序遍历序列   [4 7 2] [1] [5 3 8 6]
        //我们可以先在 前序遍历 中找到根节点
        //在 中序遍历 中找到左子树和右子树的大小
        //我们发现1是根节点，左子树有3个节点，右子树有4个节点
        //通过递归就可以完成树的重构
        //划分出来的每个子树，也就对应着相应的 前序遍历和中序遍历

        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            if (pre[0] == in[i]) {
                //将左子树表示出来（包含其的前序遍历，中序遍历）
                //注意范围是 左闭右开
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1),
                                                  Arrays.copyOfRange(in, 0, i)) ;
                //右子树同上
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, in.length),
                                                   Arrays.copyOfRange(in, i+1, in.length)) ;
            }
        }

        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
