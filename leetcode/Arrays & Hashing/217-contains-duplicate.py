class Solution:
    # pythonic solution
    # def containsDuplicate(self, nums: list[int]) -> bool:
    #     return len(nums) != len(set(nums))

    # generic solution
    def containsDuplicate(self, nums: list[int]) -> bool:
        encountered: set = set()

        for num in nums:
            if num in encountered:
                return True
            encountered.add(num)

        return False
