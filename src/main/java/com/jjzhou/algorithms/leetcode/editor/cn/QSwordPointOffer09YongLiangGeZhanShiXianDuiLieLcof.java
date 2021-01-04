//用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的
//功能。(若队列中没有元素，deleteHead 操作返回 -1 )
//
//
//
// 示例 1：
//
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]
//
//
// 示例 2：
//
// 输入：
//["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
//[[],[],[5],[2],[],[]]
//输出：[null,-1,null,null,5,2]
//
//
// 提示：
//
//
// 1 <= values <= 10000
// 最多会对 appendTail、deleteHead 进行 10000 次调用
//
// Related Topics 栈 设计
// 👍 154 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Stack;

public class QSwordPointOffer09YongLiangGeZhanShiXianDuiLieLcof {

    public static void main(String[] args) {

    }

//leetcode submit region begin(Prohibit modification and deletion)
class CQueue {

    /**
     * 数据流入的栈
     */
    private Stack<Integer> offerStack;

    /**
     * 数据流出的栈
     */
    private Stack<Integer> pollStack;

    public CQueue() {
        offerStack = new Stack<>();
        pollStack = new Stack<>();
    }

    public void appendTail(int value) {
        offerStack.push(value);
    }

    /**
     * 如果pollStack为空，则将offerStack中的所有输入压入到pollStack；否则直接pop
     * @return
     */
    public int deleteHead() {
        if (pollStack.isEmpty()) {
            while (!offerStack.isEmpty()) {
                pollStack.push(offerStack.pop());
            }
        }
        if (pollStack.isEmpty()) {
            return -1;
        }
        return pollStack.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
//leetcode submit region end(Prohibit modification and deletion)


}
