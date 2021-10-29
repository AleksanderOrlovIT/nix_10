package ua.com.alevel.level2;

public class BinaryTreeAlgorythms {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        } else {
            TreeNode current = root;
            while (current != null) {
                if (value < current.getValue()) {
                    if (current.getLeft() == null) {
                        current.setLeft(new TreeNode(value));
                        return;
                    } else {
                        current = current.getLeft();
                    }
                } else {
                    if (current.getRight() == null) {
                        current.setRight(new TreeNode(value));
                        return;
                    } else {
                        current = current.getRight();
                    }
                }
            }
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", root);
        System.out.println(sb.toString());
    }


    public int depth(TreeNode n) {
        if (n == null) {
            return 0;
        } else {
            int leftSideDepth = depth(n.getLeft());
            int rightSideDepth = depth(n.getRight());
            return 1 + Math.max(leftSideDepth, rightSideDepth);
        }
    }


    public int depth() {
        return depth(root);
    }


    public void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node) {
        if (node != null) {
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getValue());
            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);
            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();
            String pointerForRight = "└──";
            String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";

            traversePreOrder(sb, paddingForBoth, pointerForLeft, node.getLeft());
            traversePreOrder(sb, paddingForBoth, pointerForRight, node.getRight());
        }
    }

}
