/**
 * https://leetcode.com/problems/find-leaves-of-binary-tree/
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
  vector<vector<int>> findLeaves(TreeNode* root) {
    vector<vector<int>> ans = {};
    vector<int>* inner;
    while (root != nullptr) {
      inner = new vector<int>;
      root = trimLeaves(inner, root);
      ans.push_back(*inner);
    }
    return ans;
  }
  
  TreeNode* trimLeaves(vector<int>* ans, TreeNode* root) {
    if (root == nullptr) return nullptr;
    if (root->left == nullptr && root->right == nullptr) {
      ans->push_back(root->val);
      return nullptr;
    }
    root->left = trimLeaves(ans, root->left);
    root->right = trimLeaves(ans, root->right);
    return root;
  }
  
};