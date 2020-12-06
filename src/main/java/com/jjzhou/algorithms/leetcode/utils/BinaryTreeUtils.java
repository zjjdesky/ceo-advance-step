package com.jjzhou.algorithms.leetcode.utils;

import com.alibaba.fastjson.JSONObject;
import com.jjzhou.algorithms.leetcode.common.tree.binary.TreeNode;

import java.util.List;

/**
 * @author jjzhou
 * @date 2020/12/6 6:56 下午
 * @description
 */
public class BinaryTreeUtils {

    /**
     * 将json转换成二叉树
     *
     * @param json
     * @return
     */
    public static TreeNode constructBinaryTree(String json) {
        return constructBinaryTree(JSONObject.parseArray(json, Integer.class));
    }

    /**
     * 将输入的inputList转换成二叉树
     *
     * @param inputList
     * @return
     */
    public static TreeNode constructBinaryTree(List<Integer> inputList) {
        if (null == inputList || 0 == inputList.size()) {
            return null;
        }
        return getRootTreeNode(inputList, 0);
    }

    private static TreeNode getRootTreeNode(List<Integer> inputList, int index) {
        if (index < inputList.size()) {
            Integer value = inputList.get(index);
            if (null == value) {
                return null;
            }
            TreeNode node = new TreeNode(value);
            node.left = getRootTreeNode(inputList, 2 * index + 1);
            node.right = getRootTreeNode(inputList, 2 * index + 2);
            return node;
        }
        return null;
    }

}
