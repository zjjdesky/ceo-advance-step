//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
// 👍 1448 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q21MergeTwoSortedLists {

    public static void main(String[] args) {
       Solution solution = new Q21MergeTwoSortedLists().new Solution();

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head;
        if (l1.val > l2.val) {
            head = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            head = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        ListNode l1Orl2Surplus = (null == l1) ? l2 : l1;
        while (l1Orl2Surplus != null) {
            cur.next = new ListNode(l1Orl2Surplus.val);
            l1Orl2Surplus = l1Orl2Surplus.next;
            cur = cur.next;
        }

        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
