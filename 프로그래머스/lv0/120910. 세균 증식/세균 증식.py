def solution(n, t):
    changes = 1
    if t == 1:
        return n * 2
    for i in range(t):
        changes *= 2
    return changes * n