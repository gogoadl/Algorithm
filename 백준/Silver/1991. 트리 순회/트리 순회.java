import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Tree {
        Node root;
        void createNode(String data, String leftData, String rightData) {
            if (root == null) {
                root = new Node(data);
                if (!leftData.equals(".")) {
                    root.left = new Node(leftData);
                }
                if (!rightData.equals(".")) {
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
                if (!leftData.equals(".")) {
                    node.left = new Node(leftData);
                }
                if (!rightData.equals(".")) {
                    node.right = new Node(rightData);
                }
            } else {
                searchNode(node.left, data, leftData, rightData);
                searchNode(node.right, data, leftData, rightData);
            }
        }
        void preOrder(Node node, StringBuilder sb) {
            if (node != null) {
                sb.append(node.data);
                preOrder(node.left, sb);
                preOrder(node.right, sb);
            }
        }
        void inOrder(Node node, StringBuilder sb) {
            if (node != null) {
                if (node.left != null) inOrder(node.left, sb);
                sb.append(node.data);
                if (node.right != null) inOrder(node.right, sb);
            }
        }
        void postOrder(Node node,StringBuilder sb) {
            if (node != null) {
                if (node.left != null) postOrder(node.left, sb);
                if (node.right != null) postOrder(node.right, sb);
                sb.append(node.data);
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
            tree.createNode(value, lValue, rValue);
        }
        StringBuilder sb = new StringBuilder();
        tree.preOrder(tree.root, sb);
        sb.append("\n");
        tree.inOrder(tree.root, sb);
        sb.append("\n");
        tree.postOrder(tree.root, sb);
        System.out.println(sb);
    }
}
