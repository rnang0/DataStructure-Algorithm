package 链表;

/**
 * 反转链表采用递归和迭代来实现
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * @author rnang0
 * @date 2020/8/9
 */
class _206_反转链表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

//    /**
//     * 反转链表的递归实现，节点后面整体反转，指向节点
//     * @param head
//     * @return
//     */
//    public ListNode reverseList(ListNode head) {
//        // 3. 设置边界条件，递归到一个的时候，或者传进来是null了，直接返回
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        // 1. 后面整体反转：head.next为反转前的头，反转后的尾，新头是newHead
//        ListNode newHead = reverseList(head.next);
//
//        // 2. 整体（反转后的尾）指向节点，所以就不能用newHead来指向
//        head.next.next = head;
//        head.next = null;
//
//        return newHead;
//    }

    /**
     * 反转链表的迭代实现，内存占用少，效率高
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 第一个结点指向null，所以newhead指向null
        ListNode newhead = null;

        while (head != null) {
            // 1. 先保存head的next，避免后面丢失
            ListNode temp = head.next;

            // 进行将head指向新头
            head.next = newhead;
            newhead = head;

            // head依次迭代
            head = temp;
        }
        return newhead;
    }

}
