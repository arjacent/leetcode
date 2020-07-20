class Solution {
public:
  int minSteps(string s, string t) {
    int arr [26] = {0};
    int steps = 0;
    
    for (int i = 0; i < s.size(); i++) {
      arr[s[i] - 'a']++;
      arr[t[i] - 'a']--;
    }
    
    for (const auto& x : arr) steps += abs(x);
    
    return steps/2;

  }
};