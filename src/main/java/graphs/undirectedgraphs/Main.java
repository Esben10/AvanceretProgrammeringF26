package graphs.undirectedgraphs;

public class Main {

    public static void main(String[] args) {
        Node signe = new Node("Signe");
        Node ole = new Node("Ole");
        Node mia = new Node("Mia");
        Node benny = new Node("Benny");

        signe.addNeighbor(ole);
        signe.addNeighbor(mia);
        mia.addNeighbor(benny);


        System.out.println(signe);
        System.out.println(ole);
        System.out.println(mia);
    }
}
