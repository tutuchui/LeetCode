from typing import List
import math
# Leetcode 825
class Solution:
    def numFriendRequests(self , ages: List[int]) -> int:
        initial_count = 0
        size = 121
        count_list = [initial_count] * size

        for age in ages:
            count_list[age] += 1

        res = 0
        for i in range(len(count_list)):
            if count_list[i] > 0:
                max_age = i
                min_age = math.floor(0.5 * i + 7) + 1
                for age in range(min_age, max_age + 1):
                    if count_list[age] > 0:
                        if age != i:
                            res += count_list[age] * count_list[i]
                        else:
                            res += count_list[age] * (count_list[i] - 1)
        return res

if __name__ == '__main__':
    s = Solution()
    print(s.numFriendRequests([16,17,18]))