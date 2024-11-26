from typing import List

# Leetcode 3206
class Solution:
    def numberOfAlternatingGroups(self, colors: List[int]) -> int:
        start = 0
        count = 0
        while start < len(colors):
            if colors[start] != colors[(start + 1) % len(colors)] and colors[(start + 1) % len(colors)] != colors[(start + 2) % len(colors)]:
                count += 1
            start += 1
        return count

if __name__ == '__main__':
    sol = Solution()
    print(sol.numberOfAlternatingGroups([0,1,0,0,1]))