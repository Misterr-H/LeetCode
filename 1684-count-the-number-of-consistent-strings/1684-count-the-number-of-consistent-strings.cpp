class Solution {
public:
    int countConsistentStrings(string allowed, vector<string>& words) {
        ios_base::sync_with_stdio(false);
        vector<bool> appear(26, false);
        for(int i=0; i<allowed.length(); i++) {
            appear[allowed[i] - 97] = true;
        }
        int ans = 0;
        for(int i=0; i<words.size(); i++) {
            bool found = true;
            for(int j=0; j<words[i].length(); j++) {
                if(appear[words[i][j] - 97] == false) found= false;
            }
            if(found) ans++;
        }

        return ans;
    }
};