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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        int size = 0;
        ListNode* curr = head;
        while (curr != NULL) {
            size++;
            curr = curr->next;
        }
        vector<ListNode*> ans;
        int n = size / k;
        curr = head;
        if (n == 0) {
            for (int i = 0; i < k; i++) {
                ListNode* temp = curr;
                if (temp != NULL) {
                    ListNode* temp2 = temp->next;
                    temp->next = NULL;
                    ans.push_back(temp);
                    curr = temp2;
                } else {
                    ans.push_back(NULL);
                }
            }
        } else {
            int first = size%k;
            int first_size = n+1;
            ListNode* temp = curr;
            ListNode* temp2 = curr;
            for(int i=0; i<first; i++) {
                curr = temp2;
                temp = curr;
                for(int j=0; j<first_size-1;j++) {
                    curr = curr->next;
                }
                temp2 = curr->next;
                curr->next = NULL;
                ans.push_back(temp);
            }
            for(int i=0; i<k-first; i++) {
                curr = temp2;
                temp = curr;
                for(int j=0; j<n-1;j++) {
                    curr = curr->next;
                }
                temp2 = curr->next;
                curr->next = NULL;
                ans.push_back(temp);
            }
        }
        return ans;
    }
};