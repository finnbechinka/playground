class Solution:
    # # very slow 3600ms
    # def isAnagram(self, s: str, t: str) -> bool:
    #     if len(s) != len(t):
    #         return False

    #     for char in s:
    #         if s.count(char) != t.count(char):
    #             return False

    #     return True

    # faster 50ms
    def isAnagram(self, s: str, t: str) -> bool:
        sl: list[str] = list(s)
        tl: list[str] = list(t)

        sl.sort()
        tl.sort()

        if sl != tl:
            return False

        return True
