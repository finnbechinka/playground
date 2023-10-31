class Solution:
    # # pretty slow.
    # def twoSum(self, nums: list[int], target: int) -> list[int]:
    #     for i, num in enumerate(nums):
    #         diff = target - num
    #         j = None
    #         offset = i + 1
    #         pre_num = nums[:i]
    #         post_num = nums[offset:]

    #         if diff in pre_num:
    #             j = nums.index(diff)
    #         elif diff in post_num:
    #             j = post_num.index(diff)
    #             j = j + offset
    #         else:
    #             continue

    #         return [i, j]

    # faster.
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        visited: dict = {}
        for i, num in enumerate(nums):
            diff = target - num
            if diff in visited:
                return [i, visited[diff]]
            visited[num] = i
