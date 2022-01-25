package com.cl.question.btree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author chenliang
 * @since 2022/1/21 15:48
 * <p>
 * 559. N 叉树的最大深度
 * <p>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 * <p>
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxDepth {

    /**
     * 广度优先，按层遍历
     */
    public int maxDepth(Node root) {
        int level = 0;
        if (root == null) return level;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                for (Node temp : node.children) {
                    queue.add(temp);
                }
            }
            level++;
        }

        return level;
    }

    /**
     * 深度优先，子树最大深度 + 1，即为整个数的深度
     */
    public int maxDepth2(Node root) {
        if (root == null) return 0;

        List<Node> children = root.children;
        int maxDepth =  0;
        for (Node node : children) {
            maxDepth = Math.max(maxDepth, maxDepth2(node));
        }

        return maxDepth + 1;
    }
}
