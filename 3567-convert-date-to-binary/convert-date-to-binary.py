class Solution:
    def convertDateToBinary(self, date: str) -> str:
        li = date.split("-")
        s = []
        for i in li:
            s.append(bin(int(i))[2:])
        return "-".join(s)
