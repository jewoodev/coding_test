def solution():
    n, k = map(int, input().split())
    count = 0

    while n > 1:
        if n % k == 0:
            count += 1
            n = n // k

        else:
            n -= 1
            count += 1

    return count

if __name__ == '__main__':
    print(solution())