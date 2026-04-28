package graphs.treesearch;


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

        foundNode = searchDFS(500, root); // BFS search
        System.out.println("DFS starting..");
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }
    }

    public static Node searchBFS(int value, Node root) {

        return null;
    }

    public static Node searchDFS(int value, Node root) {

        return null;
    }



}