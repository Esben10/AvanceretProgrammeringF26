package graphs.treesearch;


public class SearchStrategies {

    public static void main(String[] args) {

        Node root = new Node(10); // root
        Node newChild = root.addChild(5); // root first child
        Node newChildChild = newChild.addChild(115); // root first child -> child
        newChildChild.addChild(207); // root first child -> child -> child
        newChildChild.addChild(500);
        root.addChild(7); // root second child
        newChild = root.addChild(15); // root third child
        newChild.addChild(117);

        Node foundNode = searchBFS(117, root); // BFS search
        System.out.println("BFS starting..");
        if (foundNode != null) {
            System.out.println(foundNode.getValue());
        } else {
            System.out.println("Found nothing!");
        }

        foundNode = searchDFS(117, root); // BFS search
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