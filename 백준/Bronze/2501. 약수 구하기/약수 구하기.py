arr = []
N, K = map(int, input().split())
cont = 0
for i in range(1, N + 1):
   if N % i ==0:
      arr.append(i)
   cont += 1
          
if K > len(arr):
   print(0)
else:
    print(arr[K-1])