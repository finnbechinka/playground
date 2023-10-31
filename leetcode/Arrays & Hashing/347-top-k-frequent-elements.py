from math import inf as INFINITY
from typing import Mapping


class Solution:
    # works ok.
    def topKFrequent(self, nums: list[int], k: int) -> list[int]:
        counts: Mapping[int, int] = {}

        for num in nums:
            if num in counts:
                counts[num] = counts[num] + 1
            else:
                counts[num] = 1

        return [num for num, _ in sorted(counts.items(), key=lambda count: count[1])[-k:]]
