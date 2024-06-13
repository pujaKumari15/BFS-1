import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 TC - O(n)
 SC - O(n)
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> resultList = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            while(size-- > 0) {
                TreeNode curr = queue.poll();
                list.add(curr.val);

                if(curr.left != null)
                    queue.add(curr.left);

                if(curr.right != null)
                    queue.add(curr.right);
            }

            resultList.add(list);
        }

        return resultList;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}