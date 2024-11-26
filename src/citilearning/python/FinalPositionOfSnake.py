from typing import List

# Leetcode 3248

class Solution:
    def finalPositionOfSnake(self, n: int, commands: List[str]) ->int:
        x = 0
        y = 0
        for command in commands:
            if command == 'UP':
                y = y - 1
            elif command == 'RIGHT':
                x = x + 1
            elif command == 'DOWN':
                y = y + 1
            elif command == 'LEFT':
                x = x - 1

        return n * y + x

if __name__ == '__main__':
    s = Solution()
    print(s.finalPositionOfSnake(2, ['RIGHT', 'DOWN']))
    print(s.finalPositionOfSnake(3, ['DOWN', 'RIGHT', 'UP']))
