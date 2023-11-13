def solution():
    row, col = map(int, input().split())
    min_val = 0
    list_ = []
    for i in range(row):
        list_.append(list(map(int, input().split())))

    for i in range(row):
        if min(list_[i]) > min_val:
            min_val = min(list_[i])

    return min_val

if __name__ == "__main__":
    print(solution())