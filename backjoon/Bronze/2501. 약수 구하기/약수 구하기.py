arr = []
N, K = map(int, input().split())
cont = 0
for i in range(1, N + 1):
   if N % i == 0:
      arr.append(i)
   cont += 1 # cont는 약수의 개수
          
if K > len(arr): 
   print(0)
else:
    print(arr[K-1])

'''
약수의 개수 구하기
N값이 주어지면 N값의 약수의 개수를 구하시오.
'''
import math
N = int(input())
cnt = 0
for i in range(1, int(math.sqrt(N)) + 1):
    if N == i * i:
        cnt += 1
        continue
    if N % i == 0:
        cnt += 2

print(cnt)
 """
 혹은
 """
 N = int(input())
cnt = 0
i = 1
while i * i < N:
    if N % i == 0:
        cnt += 2
    i += 1
if N == i * i:
    cnt += 1


print(cnt)

