<<<<<<< HEAD
# import sys
# input = sys.stdin.readline


N, K = map(int, input().split())
coin_list = []
cost_coin = 0

for i in range(N):
    coin_list.append(int(input()))

coin_list.reverse()

for j in coin_list:
    if K - j > 0:                # =이 빠져서 ...! 빠져서 ...! 틀렸던 거 였어!! 그리고 이걸 캐치못해서 계속 헤맸다니... 
        cost_coin += K // j
        K = K % j
    if K == 0:
        break

print(cost_coin)         # 이래도 안된다. 놓친게 있는듯
=======
"""
n = int(input())
cnt = 0

while n > 3:
    if n % 5 != 0 & n % 3 != 0:
        if (n%10) % 3 == 0:
"""
>>>>>>> 891a36352469225c1d3d4455f0cf76f898b11ecd
