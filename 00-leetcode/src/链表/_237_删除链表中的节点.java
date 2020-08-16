package 链表;

/**
 * 由于只给了当前节点，所以删除就只能从node的next的next想办法
 * 后面的值赋给node的值，再改变指针指向
 * https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author rnang0
 * @date 2020/8/9
 */
class _237_删除链表中的节点 {
    /**
     * 节点数据
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
