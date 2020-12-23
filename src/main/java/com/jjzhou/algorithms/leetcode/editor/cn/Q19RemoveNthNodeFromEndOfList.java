//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
//
// 示例：
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
//
//
// 说明：
//
// 给定的 n 保证是有效的。
//
// 进阶：
//
// 你能尝试使用一趟扫描实现吗？
// Related Topics 链表 双指针
// 👍 1152 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q19RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
       Solution solution = new Q19RemoveNthNodeFromEndOfList().new Solution();

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head || n < 0) {
            return null;
        }
        ListNode fast = head, cur = head, pre = head;
        while (n-- > 0) {
            assert null != fast;
            fast = fast.next;
        }
        if (null == fast) {
            head = head.next;
            return head;
        }
        fast = fast.next;
        cur = cur.next;
        while (fast != null) {
            fast = fast.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = cur.next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
