public class Main14 {
    /* 输入一个链表，输出该链表中倒数第k个结点。 */

    public class Solution {
        /* 采用双指针的方法【滑动窗口】 */
        public ListNode FindKthToTail(ListNode head,int k) {
            /* 1 2 3 4 5 6 【7 8 9】
            * 假设k为3
            * 那么我们让两个指针之间的距离为2，当前面的指针到达了链表的结尾，后面的指针也就到了倒数第3了
            *  */
            if (head == null || k == 0){
                return null;
            }
            //头指针一般都是空的
            //head 1 2 3 4 5 6 7 8 9
            ListNode front = head;
            ListNode behind = head;
            //让前面的指针先走k-1步
            for (int i = 1; i < k; i++){
                //当front.next == null时，是没有倒数第k个节点的
                if (front.next == null){
                    return null;
                }
                front = front.next;
            }
            //只要前面的指针的next不是空，两个指针就一起走
            while(front.next != null){
                front = front.next;
                behind = behind.next;
            }

            //当到达后，返回后面指针的节点
            return behind;
        }
    }
}

