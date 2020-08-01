//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学
// 👍 4683 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Objects;

public class Q2AddTwoNumbers {

    public static void main(String[] args) {
       Solution solution = new Q2AddTwoNumbers().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (Objects.isNull(l1)) {
            return l2;
        }
        if (Objects.isNull(l2)) {
            return l1;
        }
        int carry = (l1.val + l2.val) / 10;
        int val = (l1.val + l2.val) % 10;
        l1 = l1.next;
        l2 = l2.next;
        ListNode resListNode = new ListNode(val);
        ListNode preNode = resListNode;
        while (Objects.nonNull(l1)) {
            if (Objects.nonNull(l2)) {
                val = l1.val + l2.val + carry;
                l2 = l2.next;
            } else {
                val = l1.val + carry;
            }
            l1 = l1.next;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode currentNode = new ListNode(val);
            preNode.next = currentNode;
            preNode = currentNode;
        }
        while (Objects.nonNull(l2)) {
            val = l2.val + carry;
            l2 = l2.next;
            if (val >= 10) {
                val = val % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ListNode currentNode = new ListNode(val);
            preNode.next = currentNode;
            preNode = currentNode;
        }
        if (1 == carry) {
            ListNode currentNode = new ListNode(1);
            preNode.next = currentNode;
        }

        return resListNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
