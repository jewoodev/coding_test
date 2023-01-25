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

<<<<<<< HEAD
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
=======
print(cost_coin)
>>>>>>> 891a36352469225c1d3d4455f0cf76f898b11ecd
