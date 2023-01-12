nlist = [0, 1]
nbh = int(input())
for i in range(nbh):
    nlist.append(nlist[i] + nlist[i+1])
print(nlist[nbh])

--------------------------------------------------------------------------------

"""
다른 풀이 - 재귀 함수
def fibonacci(n):
    if n <= 1:
        return n
    return fibonacci(n-1) + fibonacci(n-2)

n = int(input())
print(fibonacci(n))
"""
