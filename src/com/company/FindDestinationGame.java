package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FindDestinationGame{

    public void searchAndInsert(Node root, Node insertNode)
    {
        if(root.x > insertNode.x)
        {
            if(root.leftNode == null)
            {
                root.leftNode = insertNode;
            }else
            {
                searchAndInsert(root.leftNode, insertNode);
            }
        }else
        {
            if(root.rightNode == null)
            {
                root.rightNode = insertNode;
            }else
            {
                searchAndInsert(root.rightNode, insertNode);
            }
        }
    }
    public void preorder(Node focusNode)
    {
        if(focusNode != null)
        {
            preorder(focusNode.leftNode);
            System.out.println(focusNode.number);
            preorder(focusNode.rightNode);
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Node[] nodearr = new Node[nodeinfo.length];
        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < nodeinfo.length; i++)
        {
            nodearr[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i + 1);
        }
        Arrays.sort(nodearr, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n2.y == n1.y ? n1.x - n2.x : n2.y - n1.y;
            }
        });
        Node root = nodearr[0];
        for(int i = 1; i < nodearr.length; i++)
        {
            searchAndInsert(root, nodearr[i]);
        }



        return answer;
    }
    public static void main(String[] args) {
        FindDestinationGame findDestinationGame = new FindDestinationGame();
        findDestinationGame.solution(new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
    }
    public class Node
    {
        int x;
        int y;
        int number;
        Node leftNode = null;
        Node rightNode = null;

        public Node(int x, int y, int number)
        {
            this.x = x;
            this.y = y;
            this.number = number;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }
}

