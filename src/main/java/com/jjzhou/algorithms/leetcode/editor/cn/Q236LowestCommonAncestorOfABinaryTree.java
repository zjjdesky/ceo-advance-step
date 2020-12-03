//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。”
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]
//
//
//
//
//
// 示例 1:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//
//
// 示例 2:
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//
//
//
//
// 说明:
//
//
// 所有节点的值都是唯一的。
// p、q 为不同节点且均存在于给定的二叉树中。
//
// Related Topics 树
// 👍 848 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;

public class Q236LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
       Solution solution = new Q236LowestCommonAncestorOfABinaryTree().new Solution();

    }

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    private Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q) {
            return null;
        }
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    private void dfs(TreeNode root) {
        if (null != root.left) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (null != root.right) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

//    private Boolean isNotFind = false;
//
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if (Objects.isNull(root) || Objects.isNull(p) || Objects.isNull(q)) {
//            return null;
//        }
//        LinkedList<TreeNode> pParents = new LinkedList<>();
//        this.isNotFind = true;
//        findParents(root, p, pParents);
//
//        LinkedList<TreeNode> qParents = new LinkedList<>();
//        this.isNotFind = true;
//        findParents(root, q, qParents);
//        while (!pParents.isEmpty()) {
//            TreeNode lastNode = pParents.pop();
//            if (qParents.contains(lastNode)) {
//                return lastNode;
//            }
//        }
//        return root;
//    }
//
//    private void findParents(TreeNode root, TreeNode p, LinkedList<TreeNode> parents) {
//        if (root == null) {
//            return;
//        }
//        if (p == root) {
//            parents.add(p);
//            this.isNotFind = false;
//            return;
//        }
//        if (this.isNotFind) {
//            parents.add(root);
//            findParents(root.left, p, parents);
//            if (this.isNotFind) {
//                parents.pop();
//            }
//        }
//        if (this.isNotFind) {
//            parents.add(root);
//            findParents(root.right, p, parents);
//            if (this.isNotFind) {
//                parents.pop();
//            }
//        }
//    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
