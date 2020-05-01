import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(final String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        int[] list = new int[] {1,2,3,4,3};
        int target = 7;
        Arrays.sort(list);

        combinationSum(list,0,new ArrayList<Integer>(),result,target);

        System.out.println(result.toString());
    }
    /**
     *  list = [1,2,3,4,3]
     * target = 7
     * output = [
     *      [3,3,1],
     *      [4,3],
     *      [4,2,1],
     * ]
     * 
     * NOTE:there must be no duplucate
     * 
     * using dfs we are going to walk though the array
     * and simulate taking and not take every item in 
     * the list .
     */
    public static void combinationSum(int[] list ,int idx,List<Integer> currentList,List<List<Integer>> result,int target){
        if(target == 0){
            /**
             * this means that the currentList is sums up 
             * to the target
             */
            result.add(new ArrayList<>(currentList));
            return;
        }
        /**
         * this means that the curentList is less than our target
         * so we can't add it to our list
         */
        if(target < 0) return;

        for (int i = idx; i < list.length; i++) {
            /**
             * the second || conditions is preventing duplicate
             * if it has check the prevoius number it should
             * not check the next
             */
            if( i == idx || list[i] != list[i -1]){
                currentList.add(list[i]);
                combinationSum(list,idx + 1,currentList,result,target - list[i]);
                if (!currentList.isEmpty()) currentList.remove( currentList.size() - 1 );
            }
        }
    }
    

}

// NOTE ALWAYS CALCULATE THE RUNTIME COMPLEXITY OF THE ALGORTIHM 
// AFTER COMPLETION

// public static int[][] list(int[][] list,int[] new_time) {
//         int[] previous_time = list[0];
//         for (int i = 0; i < list.length; i++) {
//             if(!(previous_time[1] < new_time[0])){
//                 int max_time = previous_time[1] - previous_time[0];
//                 if(!(list.length >= i+1)){
//                     list[list.length+1] = new_time;
//                 }else{
//                     int free_from_last = list[i+1][0] - previous_time[1];
//                     if(max_time >= free_from_last){
//                         // insert into thee free time
//                         throw new RuntimeException("there is a free time");
//                     }
//                     else{
//                         throw new RuntimeException("there is no free time avaible");
//                     }
//                 };
                
//             }else{
//                 if(!(list.length >= i+1))break;
//                 previous_time = list[i+1];
//             }
//         }
//         // add to the list here it mean there is a free time
//         return list;
//     }



/**
 * 
 */