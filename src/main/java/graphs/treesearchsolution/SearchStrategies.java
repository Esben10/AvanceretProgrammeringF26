package graphs.treesearchsolution;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class SearchStrategies {

    public static void main(String[] args) {

        Node root = new Node(10); // root
        Node newChild = root.addChild(5); // root first child
        root.addChild(7); // root second child
        root.addChild(15); // root third child
        Node newChildChild = newChild.addChild(115); // root first child -> child
        Node newChildChildChild = newChildChild.addChild(207); // root first child -> child -> child
        Node newChildChildChildChild = newChildChild.addChild(500);

        Node foundNode = searchBFS(500, root); // BFS search
        System.out.println("BFS starting..");
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }

        foundNode = searchDFS(500, root);
        System.out.println("DFS starting..");
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }
    }

    public static Node searchBFS(int value, Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            if(value == currentNode.getValue()){
                return currentNode;
            }
            else{
                queue.addAll(currentNode.getChildren());
            }
        }
        return null;
    }

    public static Node searchDFS(int value, Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node currentNode = stack.pop();
            if(value == currentNode.getValue()){
                return currentNode;
            }
            else{
                for(Node n:currentNode.getChildren()){
                    stack.push(n);
                }
            }
        }
        return null;
    }



}