package algorithms.floydexample;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        int[] circularArray = {1, 2, 3, 4, 5, 6, 0};

        TraversingArrays.naiveWalk(array);
     //   TraversingArrays.naiveWalk(circularArray);

       if(!TraversingArrays.hasCycle(array)){
            TraversingArrays.naiveWalk(array);
       }

       if(!TraversingArrays.hasCycle(circularArray)){
            TraversingArrays.naiveWalk(circularArray);
       }

    }
}
