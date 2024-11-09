package dataStructure.treeQuestions;

import java.util.*;

public class DivyanshuClass {
    Set<Node> visitedNode = new HashSet<>();
    Map<Node, Node> parentChildMap = new HashMap<>();
    void createParentChildMap(Node root){
        if (root == null)
            return;

        if (root.left != null) {
            parentChildMap.put(root.left, root);
            createParentChildMap(root.left);
        }

        if (root.right != null) {
            parentChildMap.put(root.right, root);
            createParentChildMap(root.right);
        }
    }

    LinkedList<Node> queue = new LinkedList<>();
    Node findLeastDistance(Node root){
        queue.add(root);

        while(!queue.isEmpty()) {
            for(int i=0; i< queue.size(); i++) {
                System.out.println("queue value:" +queue.get(i).key);
            }

            Node node = queue.poll();
            visitedNode.add(node);

            if(node.left == null && node.right == null){
                return node;
            }
            if(node.left !=null && !visitedNode.contains(node))
                queue.add(node.left);
            if(node.right != null && !visitedNode.contains(node))
                queue.add(node.right);
            queue.add(parentChildMap.get(node));
        }
        return null;
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(10);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.right = new Node(6);
        root.right.right.right = new Node(7);
        root.right.left.right.left = new Node(8);
        root.right.right.right.left = new Node(9);
        Node.printTreeDiagram(root);



        DivyanshuClass obj = new DivyanshuClass();
        obj.createParentChildMap(root);
        obj.parentChildMap.forEach((k,v) -> System.out.println(k.key + "  " + v.key));
        System.out.println(obj.findLeastDistance(root.right).key);


    }
}
