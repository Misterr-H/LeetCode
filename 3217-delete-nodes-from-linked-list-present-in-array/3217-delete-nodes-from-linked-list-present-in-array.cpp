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
    ListNode* modifiedList(vector<int>& nums, ListNode* head) {
        vector<bool> check(1e5, false);
        for(int i=0; i<nums.size(); i++) {
            check[nums[i]] = true;
        }
        ListNode* curr = head;
        ListNode* prev = NULL;
        while(curr!=NULL) {
            if(check[curr->val] == true) {
                if(curr == head) {
                    head = curr->next;
                    curr = head;
                } else {
                    prev->next = curr->next;
                    curr = curr->next;
                }
            } else {
                prev = curr;
                curr = curr->next;
            }
        }
        return head;

    }
};