/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> spiralMatrix(int m, int n, ListNode* head) {
        vector<vector<int>> ans(m, vector<int>(n, -1));
        int topRow = 0, bottomRow = m-1, leftColumn = 0, rightColumn = n-1;
        
        while(head) {
            for(int col = leftColumn; col <= rightColumn && head; ++col) {
                ans[topRow][col] = head->val;
                head = head->next;
            }
            topRow++;

            for(int row = topRow; row<=bottomRow && head; ++row) {
                ans[row][rightColumn] = head->val;
                head = head->next;
            }
            rightColumn--;

            for(int col = rightColumn; col>=leftColumn && head; --col) {
                ans[bottomRow][col] = head->val;
                head = head->next;
            }
            bottomRow--;
            for (int row = bottomRow; row >= topRow && head; --row) {
                ans[row][leftColumn] = head->val;
                head = head->next;
            }
            leftColumn++;
        }

        return ans;
    }
};