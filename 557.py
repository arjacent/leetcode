class Solution:
    def reverseWords(self, s: str) -> str:
      sr = s.split(" ")
      ans = ""
      for s1 in sr:
        ans = ans + s1[::-1] + " "
      return ans[:len(ans)-1]
        
