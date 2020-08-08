class Solution {
  public boolean checkIfCanBreak(String s1, String s2) {
    char[] arr1 = s1.toCharArray();
    char[] arr2 = s2.toCharArray();
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    boolean flag1 = true;
    boolean flag2 = true;
    for (int i = 0; i < s1.length(); i++) {
      if (arr1[i] < arr2[i]) flag1 = false;
      if (arr1[i] > arr2[i]) flag2 = false;
      if (!flag1 && !flag2) return false;
    }
    return true;
  }
}