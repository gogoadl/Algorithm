package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindDestinationGame{

    class Node {
        Node leftNode = null;
        Node rightNode = null;
        int data;
        int x;
        int y;
        public Node(int data, int x, int y) {
            this.data = data;
            this.x = x;
            this.y = y;
        }
    }
    public void insert(Node rootNode, Node insertNode) {
        if(rootNode.x > insertNode.x) {
            if(rootNode.leftNode == null)
                rootNode.leftNode = insertNode;
            else
                insert(rootNode.leftNode, insertNode);
        }else {
            if(rootNode.rightNode == null)
                rootNode.rightNode = insertNode;
            else
                insert(rootNode.rightNode, insertNode);
        }
    }
    public void preOrder(Node node, ArrayList arrayList){
        arrayList.add(node.data);
        if(node.leftNode != null)
            preOrder(node.leftNode, arrayList);
        if(node.rightNode != null)
            preOrder(node.rightNode, arrayList);
    }
    public void postOrder(Node node, ArrayList arrayList){

        if(node.leftNode != null)
            postOrder(node.leftNode, arrayList);
        if(node.rightNode != null)
            postOrder(node.rightNode, arrayList);
        arrayList.add(node.data);
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        Node[] nodes = new Node[nodeinfo.length];

        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1,nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node node1, Node node2) {
                return node1.y == node2.y ? node1.x - node2.x : node2.y - node1.y;
            }
        });

        for (int i = 1; i < nodes.length; i++) {
            insert(nodes[0], nodes[i]);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        preOrder(nodes[0], arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            answer[0][i] = arrayList.get(i);
        }
        arrayList.clear();
        postOrder(nodes[0], arrayList);
        for (int i = 0; i < arrayList.size(); i++) {
            answer[1][i] = arrayList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        FindDestinationGame findDestinationGame = new FindDestinationGame();
        findDestinationGame.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }
}

