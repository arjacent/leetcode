class Solution {
  StringBuilder sb;
  List<String> ans;
  
  public String[] expand(String S) {
    ans = new ArrayList<>();
    sb  = new StringBuilder();
    backtrack(S, 0);
    
    String[] arr = new String[ans.size()];
    for (int i = 0; i < ans.size(); i++) {
      arr[i] = ans.get(i);
    }
    Arrays.sort(arr);
    return arr;
  }
  
  public void backtrack(String S, int i) {
    String x = sb.toString();
    if (i >= S.length()) {
      ans.add(sb.toString());
      return;
    }
    
    if (S.charAt(i) == '{') {
      int j = i+1;
      // skip to end of {
      while (S.charAt(i) != '}') {          
        i = i + 2;
      }
      i++;
      // consider each char
      while (j < i) {
        sb.append(S.charAt(j));
        backtrack(S, i);
        sb.setLength(sb.length() - 1);
        j = j+2;
      } 
    } else {
      sb.append(S.charAt(i));
      backtrack(S, i+1);
      sb.setLength(sb.length() - 1);
    }
  }
}
