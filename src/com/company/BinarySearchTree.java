package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private Node root;

    public class Node {
        private int key;
        private Node leftChild;
        private Node rightChild;

        Node(int key)
        { this.key = key; }
    }
    public Node getRoot(){
        return this.root;
    }
    public void addNode(int key)
    {
        if(findNode(key) != null) { return; }

        Node newNode = new Node(key);

        if(root == null)
        {
            root = newNode;
        }else
        {
            Node focusNode = root;
            Node parent;

        while (true)
        {
            parent = focusNode;
            if(key < parent.key)
            {
                focusNode = parent.leftChild;

                if(focusNode == null)
                {
                    parent.leftChild = newNode;
                    return;
                }
            } else
            {
                focusNode = parent.rightChild;

                if(focusNode == null)
                {
                    parent.rightChild  = newNode;
                    return;
                }
            }
        }
        }
    }
    public boolean deleteNode(int key) {
        // focusNode 와 parent 가 같을 수 있는 경우는 찾으려는 key 가 root 인 경우
        Node focusNode = root;
        Node parent = root;

        boolean isLeftChild = true;

        // while 문이 끝나고 나면 focusNode 는 삭제될 노드를 가리키고, parent 는 삭제될 노드의 부모노드를 가리키게 되고, 삭제될 노드가 부모노드의 left 인지 right 인지에 대한 정보를 가지게 된다
        while(focusNode.key != key) {
            parent = focusNode;

            if(key < focusNode.key) {
                isLeftChild = true;             // 지우려는 노드가 왼쪽에 있는 노드냐 기록용
                focusNode = parent.leftChild;
            } else {
                isLeftChild = false;            // 지우려는 노드가 오른쪽에 있는 노드냐 기록용
                focusNode = parent.rightChild;
            }

            // 찾으려는 노드가 없는 경우
            if(focusNode == null) {
                return false;
            }
        }


        Node replacementNode;
        // 지우려는 노드의 자식 노드가 없는 경우
        if(focusNode.leftChild == null && focusNode.rightChild == null) {
            if (focusNode == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        // 지우려는 노드의 오른쪽 자식노드가 없는 경우 (왼쪽 자식 노드만 있는 경우)
        else if(focusNode.rightChild == null) {
            replacementNode = focusNode.leftChild;

            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // 지우려는 노드의 왼쪽 자식노드가 없는 경우 (오른쪽 자식 노드만 있는 경우)
        else if (focusNode.leftChild == null) {
            replacementNode = focusNode.rightChild;
            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;
        }
        // 지우려는 노드의 양쪽 자식노드가 모두 있는 경우
        // 오른쪽 자식 노드의 sub tree 에서 가장 작은 노드를 찾아서 지우려는 노드가 있던 자리에 위치시킨다
        else {
            Node rightSubTree = focusNode.rightChild;                   // 삭제될 노드의 오른쪽 sub tree 를 저장해둔다
            replacementNode = getRightMinNode(focusNode.rightChild);    // 삭제될 노드 자리에 오게 될 새로운 노드 (오른쪽 sub tree 에서 가장 작은 값을 가진 노드). 이 노드는 왼쪽 child 가 없어야 한다 (가장 작은 값이기 때문에)

            if (focusNode == root)
                root = replacementNode;
            else if (isLeftChild)
                parent.leftChild = replacementNode;
            else
                parent.rightChild = replacementNode;

            replacementNode.rightChild = rightSubTree;
            if (replacementNode == rightSubTree)                // 지우려는 노드의 오른쪽 sub tree 에 노드가 하나밖에 없는 경우
                replacementNode.rightChild = null;

            replacementNode.leftChild = focusNode.leftChild;    // 지우려는 노드의 왼쪽 sub tree 를 연결시킨다
        }

        return true;
    }

    private Node getRightMinNode(Node rightChildRoot) {
        Node parent = rightChildRoot;
        Node focusNode = rightChildRoot;

        while (focusNode.leftChild != null) {
            parent = focusNode;
            focusNode = focusNode.leftChild;
        }

        parent.leftChild = null;
        return focusNode;
    }

    public void inOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverse(focusNode.leftChild);
            System.out.print(focusNode.key + " ");
            inOrderTraverse(focusNode.rightChild);
        }
    }

    public void preOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            System.out.print(focusNode.key + " ");
            preOrderTraverse(focusNode.leftChild);
            preOrderTraverse(focusNode.rightChild);
        }
    }

    public void postOrderTraverse(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverse(focusNode.leftChild);
            postOrderTraverse(focusNode.rightChild);
            System.out.print(focusNode.key + " ");
        }
    }

    public Node findNode(int key) {
        // 트리가 비었을 때
        if (root == null) return null;

        Node focusNode = root;

        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            } else {
                focusNode = focusNode.rightChild;
            }

            // 찾으려는 노드가 없을 때
            if (focusNode == null)
                return null;
        }

        return focusNode;
    }

    public void BFS()
    {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.key + " ");
            if (n.leftChild !=null)
                q.offer(n.leftChild);
            if (n.rightChild !=null)
                q.offer(n.rightChild);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bTree = new BinarySearchTree();

        /**
         *           50
         *         /    \
         *        25    75
         *       / \    / \
         *     15  30  70 85
         *    /\   / \
         *   2 18 26 32
         */
        // Adding nodes to the BinarySearchTree
        bTree.addNode(50);
        bTree.addNode(25);
        bTree.addNode(75);
        bTree.addNode(15);
        bTree.addNode(30);
        bTree.addNode(70);
        bTree.addNode(85);
        bTree.addNode(2);
        bTree.addNode(18);
        bTree.addNode(26);
        bTree.addNode(32);
        bTree.addNode(32);
        bTree.addNode(32);
        bTree.addNode(32);

        bTree.BFS();


        // Tree traversal
        System.out.println("---------- In Order Traversal ----------");
        bTree.inOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Pre Order Traversal ----------");
        bTree.preOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Post Order Traversal ----------");
        bTree.postOrderTraverse(bTree.getRoot());
        System.out.println("\n");

        System.out.println("---------- Find Node ----------");
        Node found = bTree.findNode(25);
        System.out.println(found == null ? "not exists" : found.key);
        System.out.println("\n");

        // Deleting node
        System.out.println("---------- Delete Node Test ----------");
        bTree.deleteNode(15);
        bTree.BFS();
        System.out.println();
    }
}

