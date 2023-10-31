# struggled with this, had to look at the solution/explanation multiple times...
# it just never really clicked
class Solution:
    def productExceptSelf(self, nums: list[int]) -> list[int]:
        answer: list[int] = [1] * len(nums)

        for i in range(1, len(nums)):
            answer[i] = answer[i - 1] * nums[i - 1]
        post = 1
        for i in range(len(nums) - 1, -1, -1):
            answer[i] = answer[i] * post
            post *= nums[i]

        return answer
