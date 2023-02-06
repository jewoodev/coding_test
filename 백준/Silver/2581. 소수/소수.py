m = int(input())
n = int(input())
prime_list = []

if m <= 2:
    if n != 1:
        prime_list.append(2)

for i in range(m, n+1):
    if i <= 1:
        continue
    else:
        for j in range(2, i):
            if i % j == 0:
                break
            else:
                if j == i-1:
                    prime_list.append(i)

if len(prime_list) == 0:
    print(-1)
else:
    sum_prime = 0
    for i in prime_list:
        sum_prime += i
    print(sum_prime)
    print(prime_list[0])


### 다른 풀이 ###
"""
M = int(input())
N = int(input())

sosu_list = []
for num in range(M, N+1): # M이상 ~ N이하의 수
    count = 0 # 나눠지는 수가 있으면 카운트
    if num > 1: # 2이상의 수들 중에 소수를 찾는다.
        for i in range(2, num): # 2~num에서 나눠지는 수를 찾는다
            if num % i == 0: # 나머지가 0이면 나눠지는 수(소수 아님)
                count += 1 # 소수가 아님을 카운트
                break
        if count == 0: # 나눠지는 수가 없으면 소수
            sosu_list.append(num)


if len(sosu_list) > 0:
    print(sum(sosu_list))
    print(min(sosu_list))
else:
    print(-1)
"""

"""

# input
M = int(input())
N = int(input())

# process
decimal = []
for i in range(M, N+1):
	for j in range(2, i+1):
		if j == i:
			decimal.append(i)
		if i % j == 0:
			break

# output
if not decimal:
	print(-1)
else:
	print(sum(decimal))
	print(decimal[0])
"""

"""
m=int(input())
n=int(input())
li=[]
for i in range(m,n+1):
    e=0
    if i>1:
        for j in range(2,i):
            if i%j==0:
                e+=1
                break
        if e==0:
            li.append(i)

if len(li)<1:
    print(-1)
else:
    print(sum(li))
    print(min(li))
"""