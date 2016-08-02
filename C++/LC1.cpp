class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i;
        vector<int> ans;
        map<int, int> position;
        
        if (nums.size() == 0) return ans;
        for (i = 0; i < nums.size(); i++) {
            auto iter = position.find(target - nums[i]);
			
            if (iter != position.end()) {
                ans.push_back(iter->second);
                ans.push_back(i);
                return ans;
            }
            position[nums[i]] = i;
        }
        return ans;
    }
};