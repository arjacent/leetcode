class Solution {
  public List<List<String>> groupStrings(String[] strings) {
    
    Map<String, List<String>> map = new HashMap<>();  // <code, string>
    
    String code = "";
    for (String s : strings) {
      code = computeShift(s);
      if (map.containsKey(code)) {
        map.get(code).add(s);
      } else {
        List<String> lst = new ArrayList<>();
        lst.add(s);
        map.put(code, lst);
      }      
    }
    
    List<List<String>> ans = new ArrayList<>();
    for (String code2 : map.keySet()) {
      ans.add(map.get(code2));
    }
    
    return ans;

  }
  
  public String computeShift(String s) {
    if (s.length() == 0) return "";
    StringBuilder sb = new StringBuilder();
    sb.append("a");
    char x = (char) (s.charAt(0) - 'a');
    
    for (int i = 1; i < s.length(); i++) {
      sb.append((s.charAt(i) - x)%26);
    }
    return sb.toString();
  }
}