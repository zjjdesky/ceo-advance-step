//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
//
//
// 示例 1：
//
// 输入：head = [1,3,2]
//输出：[2,3,1]
//
//
//
// 限制：
//
// 0 <= 链表长度 <= 10000
// Related Topics 链表
// 👍 81 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class QSwordPointOffer06CongWeiDaoTouDaYinLianBiaoLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer06CongWeiDaoTouDaYinLianBiaoLcof().new Solution();

    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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
class Solution {
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        reverse(head, ans);
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i ++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void reverse(ListNode head, List<Integer> ans) {
        if (head == null) {
            return;
        }
        reverse(head.next, ans);
        ans.add(head.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
