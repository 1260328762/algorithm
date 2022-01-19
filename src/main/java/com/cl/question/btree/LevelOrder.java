package com.cl.question.btree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenliang
 * @since 2022/1/18 17:45
 * <p>
 * 面试题32 - I. 从上到下打印二叉树
 * <p>
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {

    /**
     * 队列解法: 先将二叉树根节点插入队列，循环队列头部获取节点，将该节点左右节点依次插入队列尾部
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

            result.add(node.val);
        }

        int[] finalResult = new int[result.size()];
        int index = 0;
        for (int i : result) {
            finalResult[index++] = i;
        }

        return finalResult;
    }

    /**
     * 二位数组解法：创建一个二位数组，按层将每一层的节点保存到对应的数组中，然后遍历二维数组输出结果
     */
    public int[] levelOrder2(TreeNode root) {
        if (root == null) return new int[0];
        // 创建二维数组，并将根节点添加到第一层
        List<List<TreeNode>> treeNodes = new ArrayList<>();
        treeNodes.add(Collections.singletonList(root));
        int level = 0;

        // 遍历二维数组，将每一层的节点的子节点，添加到下面一层
        while (true) {
            List<TreeNode> children = treeNodes.get(level);
            List<TreeNode> list = new ArrayList<>();
            for (TreeNode temp : children) {
                if (temp.left != null) list.add(temp.left);
                if (temp.right != null) list.add(temp.right);
            }

            if (list.isEmpty()) break;
            treeNodes.add(list);
            level++;
        }

        // 遍历打印结果
        List<Integer> result = new ArrayList<>();
        for (List<TreeNode> treeNode : treeNodes) {
            for (TreeNode node : treeNode) {
                result.add(node.val);
            }
        }

        int[] finalResult = new int[result.size()];
        int index = 0;
        for (Integer i : result) {
            finalResult[index++] = i;
        }

        return finalResult;
    }
}

