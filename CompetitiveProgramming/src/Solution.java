import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public void allTraversals(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {
        if (root == null) return;

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 1));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();

            if (p.state == 1) {
                pre.add(p.node.val);
                p.state++;
                stack.push(p);
                if (p.node.left != null)
                    stack.push(new Pair(p.node.left, 1));

            } else if (p.state == 2) {
                in.add(p.node.val);
                p.state++;
                stack.push(p);
                if (p.node.right != null)
                    stack.push(new Pair(p.node.right, 1));

            } else {
                post.add(p.node.val);
            }
        }
    }

    // For testing
    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3));

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        s.allTraversals(root, preorder, inorder, postorder);

        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }
}
