class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int n = arrays.size();
        int mini = 1e5;
        int maxi = -1e5;
        int diff = 0;
        for(auto& arr: arrays) {
            int a0 = arr[0], an = arr.back();
            diff = max({diff, an-mini, maxi-a0});
            mini = min(mini, a0);
            maxi = max(maxi, an);
        }
        return diff;
    }
};