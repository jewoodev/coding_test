N, K = map(int, input().split())
coin_list = []
cost_coin = 0

for i in range(N):
    coin_list.append(int(input()))

coin_list.reverse()

for j in coin_list:
    if K - j >= 0:
        cost_coin += K // j
        K = K % j
    if K == 0:
        break

print(cost_coin)