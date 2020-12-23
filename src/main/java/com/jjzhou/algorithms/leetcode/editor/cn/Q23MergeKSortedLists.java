//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
// 示例 2：
//
// 输入：lists = []
//输出：[]
//
//
// 示例 3：
//
// 输入：lists = [[]]
//输出：[]
//
//
//
//
// 提示：
//
//
// k == lists.length
// 0 <= k <= 10^4
// 0 <= lists[i].length <= 500
// -10^4 <= lists[i][j] <= 10^4
// lists[i] 按 升序 排列
// lists[i].length 的总和不超过 10^4
//
// Related Topics 堆 链表 分治算法
// 👍 1050 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q23MergeKSortedLists {

    public static void main(String[] args) {
       Solution solution = new Q23MergeKSortedLists().new Solution();

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
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }
        ListNode head = getHead(lists);
        if (null == head) {
            return null;
        }
        ListNode cur = head;
        while (isNotEmpty(lists)) {
            cur.next = getHead(lists);
            cur = cur.next;
        }

        return head;
    }

    private ListNode getHead(ListNode[] heads) {
        int minIndex = findFirstNotNullNodeIndex(heads);
        if (-1 == minIndex) {
            return null;
        }
        for (int i = minIndex + 1; i < heads.length; i ++) {
            if (heads[i] == null) {
                continue;
            }
            if (heads[minIndex].val > heads[i].val) {
                minIndex = i;
            }
        }

        ListNode minNode = heads[minIndex];
        heads[minIndex] = heads[minIndex].next;
        return new ListNode(minNode.val);
    }

    private int findFirstNotNullNodeIndex(ListNode[] heads) {
        for (int i = 0; i < heads.length; i ++) {
            if (heads[i] != null) {
                return i;
            }
        }
        return -1;
    }

    private boolean isNotEmpty(ListNode[] heads) {
        for (int i = 0; i < heads.length; i ++) {
            if (heads[i] != null) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
