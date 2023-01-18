T = int(input())
for i in range(T):
    input_val = list(map(int, input().split()))
    input_val.sort()
    print(input_val[-3])