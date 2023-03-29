def solution(n):
    n2 = n ** (1/2)
    if n2 % 1 == 0:
        return 1
    return 2