package dataStructure.treeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class Traversals {

    private Queue<Node> queue = new LinkedList<>();
    void BFS(Node root) {
        if (root != null) {
            queue.add(root);
            while (queue.size() != 0) {
                Node elem = queue.poll();
                System.out.print(elem.key + " ");
                if (elem.left != null) {
                    queue.add(elem.left);
                }
                if (elem.right != null) {
                    queue.add(elem.right);
                }
            }
        }
    }

    void DFS(Node root) {
        if (root!= null) {
            System.out.print(root.key + " ");
            if(root.left != null)
                DFS(root.left);
            if(root.right != null)
                DFS(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node.printTreeDiagram(root);
        new Traversals().BFS(root);
        System.out.println();
        new Traversals().DFS(root);
    }
}
