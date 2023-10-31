import math


class Solution:
    # this is quite slow...
    # def isValidSudoku(self, board: list[list[str]]) -> bool:
    #     rows: list[list[str]] = [[] for _ in range(10)]
    #     cols: list[list[str]] = [[] for _ in range(10)]
    #     boxes: list[list[str]] = [[] for _ in range(10)]

    #     for x, row in enumerate(board):
    #         for y, field in enumerate(row):
    #             if field == ".":
    #                 continue
    #             rows[x].append(field)
    #             if rows[x].count(field) > 1:
    #                 return False
    #             cols[y].append(field)
    #             if cols[y].count(field) > 1:
    #                 return False
    #             boxRow = math.floor(x / 3)
    #             boxCol = math.floor(y / 3)
    #             offset = boxRow * 3
    #             box = boxCol + offset
    #             boxes[box - 1].append(field)
    #             if boxes[box - 1].count(field) > 1:
    #                 return False

    #     return True

    # turns out using the build in floor division operator //
    # (that I did'nt know about) instead of math.floor takes
    # this from a runtime beating around 30-40% to beating 80-90%...
    def isValidSudoku(self, board: list[list[str]]) -> bool:
        rows: list[list[str]] = [[] for _ in range(10)]
        cols: list[list[str]] = [[] for _ in range(10)]
        boxes: list[list[str]] = [[] for _ in range(10)]

        for x, row in enumerate(board):
            for y, field in enumerate(row):
                if field == ".":
                    continue
                rows[x].append(field)
                if rows[x].count(field) > 1:
                    return False
                cols[y].append(field)
                if cols[y].count(field) > 1:
                    return False
                boxRow = x // 3
                boxCol = y // 3
                offset = boxRow * 3
                box = boxCol + offset
                boxes[box - 1].append(field)
                if boxes[box - 1].count(field) > 1:
                    return False

        return True
