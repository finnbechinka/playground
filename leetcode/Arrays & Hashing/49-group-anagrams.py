from typing import Mapping


class Solution:
    # pretty decent
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        result: Mapping[str, list[str]] = {}
        while strs:
            string: str = strs.pop()
            sorted_string: str = "".join(sorted(string))
            if sorted_string in result:
                result[sorted_string].append(string)
            else:
                result[sorted_string] = [string]

        return list(result.values())
