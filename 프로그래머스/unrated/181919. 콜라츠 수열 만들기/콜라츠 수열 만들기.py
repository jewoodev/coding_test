def solution(n):
    collatz = []
    while n != 1:
        collatz.append(n)
        if n % 2 == 0:
            n /= 2
        else:
            n = 3 * n + 1
    collatz.append(1)
    
    return collatz