// prettier-ignore

<!-- prettier-ignore-start -->

# 1929. Concatenation of Array

## Problem
Given an integer array `nums`, return an array `ans` such that:
`ans = nums + nums`
# My Solution
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            ans[i + nums.length] = nums[i];
        }
        return ans;
    }
}

# Optimal Solution
class Solution {
    public int[] getConcatenation(int[] nums) {

        int ans[] = new int[nums.length * 2];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[i % nums.length];
        }

        return ans;
    }
}
-- Use modulo when cycling through a fixed-size array. i % n

# MY Solution
# 217. Contains Duplicate
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}

# 1 Two Sum
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num))
                return new int[] {map.get(target - num),i};
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}

# 242.Valid Anagram
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        Map<Character,Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for (char c : t.toCharArray()) {
            map2.put(c,map2.getOrDefault(c,0) + 1);
        }
        return map.equals(map2);
    }
}
<!-- prettier-ignore-end -->
