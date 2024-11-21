from typing import List
import math
# Leetcode 825
class Solution:
    def numFriendRequests(self , ages: List[int]) -> int:
        initial_count = 0
        size = 121
        count_list = [initial_count] * size
        prefix_sum_list = [initial_count] * size

        for age in ages:
            count_list[age] += 1

        for i in range(1, size):
            prefix_sum_list[i] = prefix_sum_list[i - 1] + count_list[i]

        res = 0
        for i in range(len(count_list)):
            if count_list[i] > 0:
                min_age = math.floor(0.5 * i + 7)
                res += max(count_list[i] * (prefix_sum_list[i] - prefix_sum_list[min_age] - 1), 0)
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.numFriendRequests([108,115,5,24,82]))