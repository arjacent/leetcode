# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
  numbers = []
  
  def sumRootToLeaf(self, root: TreeNode) -> int:
    self.numbers.clear()
    self.backtrack(root, 0b0)
    return sum(self.numbers)

  def backtrack(self, root, path):
    if root is None:
      return
    path = path << 1
    if (root.val == 1):
      path += 0b1
    if root.left is None and root.right is None:
      self.numbers.append(path)
      path = path >> 1
    else:
      self.backtrack(root.left, path)
      self.backtrack(root.right, path)
      path = path >> 1
      
      
        
