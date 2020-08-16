package 链表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @author rnang0
 * @date 2020/8/11
 **/
public class _141_环形链表 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

//    /**
//     * 使用快慢指针解决链表是否有环
//     * @param head
//     * @return
//     */
//    public boolean hasCycle(ListNode head) {
//        // 对head进行入参检验（一个节点或者为null）
//        if (head == null || head.next == null) {
//            return false;
//        }
//
//        ListNode low = head;
//        ListNode fast = head.next;
//
//        while (fast != null && fast.next != null) {
//            if (low == fast) {
//                return true;
//            }
//
//            low = low.next;
//            fast = fast.next.next;
//        }
//
//        return false;
//    }

    /**
     * 使用hash表实现判断是否有环
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        // 1. 入参的检验（一个或者就是null）
        if (head == null || head.next == null) {
            return false;
        }

        // 2. 用hash表实现的列表set进行存储并校验
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;

        // 3. node.next != null没有到尾部，这样做少判断一次
        while (node.next != null) {
            if (set.contains(node)) {
                return true;
            }
            // 4. 没有就加入进去
            set.add(node);
            node = node.next;
        }

        return false;
    }

}
