package algorithms.circularlinkedlist;



import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node list = ListFactory.buildList(1, 2, 3, 4, 5);
      //  if(!hasCircle(list))
        System.out.println(list);

        Node circularList = ListFactory.buildListWithCycle();
      //   if(!hasCircle(circularList))
        System.out.println("Head: " + circularList.value);
    }



}
