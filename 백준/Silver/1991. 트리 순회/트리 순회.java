import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Tree {
        Node root;
        void createNode(String data, String leftData, String rightData) {
            if (root == null) {
                root = new Node(data);
                if (leftData != null) {
                    root.left = new Node(leftData);
                }
                if (rightData != null) {
                    root.right = new Node(rightData);
                }
            } else {
                searchNode(root, data, leftData, rightData);
            }
        }
        void searchNode(Node node, String data, String leftData, String rightData) {
            if (node == null) {
                return;
            } else if (node.data.equals(data)) {
                if (leftData != null) {
                    node.left = new Node(leftData);
                }
                if (rightData != null) {
                    node.right = new Node(rightData);
                }
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }
        void preOrder(Node node) {
            if (node != null) {
                System.out.print(node.data);
                preOrder(node.left);
                preOrder(node.right);
            }
        }
        void inOrder(Node node) {
            if (node != null) {
                if (node.left != null) inOrder(node.left);
                System.out.print(node.data);
                if (node.right != null) inOrder(node.right);
            }
        }
        void postOrder(Node node) {
            if (node != null) {
                if (node.left != null) postOrder(node.left);
                if (node.right != null) postOrder(node.right);
                System.out.print(node.data);
            }
        }
    }
    static class Node {
        String data;
        Node left;
        Node right;
        Node (String data) {
            this.data = data;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String lValue = st.nextToken();
            String rValue = st.nextToken();
            if (lValue.equals("."))
                lValue = null;
            if (rValue.equals("."))
                rValue = null;
            tree.createNode(value, lValue, rValue);
        }
        tree.preOrder(tree.root);
        System.out.println("");
        tree.inOrder(tree.root);
        System.out.println("");
        tree.postOrder(tree.root);
    }
}
