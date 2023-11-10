def solution():
    result = 0

    n, m, k = map(int, input().split())
    list_1 = list(map(int, input().split()))

    list_1.sort(reverse=True)

    result += list_1[1] * (m // k)
    result += list_1[0] * (m - (m // k))

    return result

if __name__ == "__main__":
    print(solution())