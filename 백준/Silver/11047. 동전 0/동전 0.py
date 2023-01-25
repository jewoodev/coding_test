"""
import sys
input = sys.stdin.readline


N, K = map(int, input().split())
coin_list = []
rmdr = K
cost_coin = 0

for i in range(N):
    coin_list.append(int(input()))

while 1:
    for i in range(len(coin_list)):
        if rmdr < coin_list[i]:
            cost_coin += rmdr // coin_list[i-1]
            rmdr = rmdr % coin_list[i-1]
            break
    if rmdr == 0:                          # 이 조건을 따지는 순서가 나중이라 시간 초과가 걸리는 것인가 싶어 while 조건문 바로 아래로 옮겼지만 고쳐지지 않았다.
        break

print(cost_coin)
"""

"""
import sys
input = sys.stdin.readline


N, K = map(int, input().split())
coin_list = []
rmdr = K
cost_coin = 0

for i in range(N):
    coin_list.append(int(input()))


for i in range(len(coin_list)):
    for i in range(len(coin_list)):
        if rmdr < coin_list[i]:
            cost_coin += rmdr // coin_list[i-1]
            rmdr = rmdr % coin_list[i-1]
            break
    if rmdr == 0:
        break


print(cost_coin)       # 이래도 뜬다.
"""

"""
### 다른 풀이를 보았다. ###

import sys
input = sys.stdin.readline


N, K = map(int, input().split())
coin_list = []
cost_coin = 0

for i in range(N):
    coin_list.append(int(input()))

coin_list.reverse()

for i in coin_list:
    if K - i > 0:
        cost_coin += K // i
        K = K % i         # 와 이래도 안되네;;

print(cost_coin)
"""

"""
import sys
input = sys.stdin.readline


N, K = map(int, input().split())
coin_list = []
cost_coin = 0

for i in range(N):
    coin_list.append(int(input()))

coin_list.reverse()

for i in coin_list:
    if K == 0:
        break
    elif K - i > 0:
        cost_coin += K // i
        K = K % i

print(cost_coin)         # 이래도 안된다. 놓친게 있는듯
"""


n, k = map(int, input().split()) # n은 동전의 종류, k는 만들어야 할 금액
a = []
m = 0    # 횟수

for i in range(n) :                # 동전의 종류 n개 리스트로 정렬
    a.append(int(input()))

a.reverse()   # [50000,10000,5000,1000,500,100,50,10,5,1]

for j in range(n) :
    if k - a[j] >= 0 :    
        m += k // a[j]    # k를 a[j]로 나눈 몫을 더함 
        k = k % a[j]      # k는 k를 a[j]로 나눈 나머지가 됨  
    if k == 0 : break    
        
print(m)

# ... 대체 뭘까...

"""
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
"""