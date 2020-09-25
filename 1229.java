/* 1229. Meeting Scheduler */

class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
      
      // sort intervals by start time
      Arrays.sort(slots1, (int[] a, int[] b)->a[0]-b[0]);
      Arrays.sort(slots2, (int[] a, int[] b)->a[0]-b[0]);
      
      int i = 0;
      int j = 0;
      List<Integer> lst = new ArrayList<>();
      int x = 0, y = 0;
      
      while (i < slots1.length && j < slots2.length) {
        // overlap?
        if (slots1[i][0] <= slots2[j][0] || slots2[j][0] <= slots1[i][1]) {
          x = Math.max(slots1[i][0], slots2[j][0]);
          y = Math.min(slots1[i][1], slots2[j][1]);
          if (y - x >= duration) {
            lst.add(x);
            lst.add(x+duration);
            return lst;
          }
        }          
        // advance pointers
        if (slots1[i][1] > slots2[j][1]) j++;
        else if (slots1[i][1] < slots2[j][1]) i++;
        else {
          i++;
          j++;
        }        
      }
      return lst;        
    }
}
