a, b = map(int, input().split())
progression = []

for i in range(1, 100):
    for j in range(1, i+1):
        progression.append(i)

sum_result = 0
for i in range(a-1, b):
    sum_result += progression[i]
print(sum_result)

### 다른 풀이 ###

"""
a, b = map(int, input().split())
 
arr = [0]
cnt = 1
for i in range(1, (b+1) // 2 + 1):    # 범위를 반으로 나눠서 시간 단축
    for j in range(cnt):
        arr.append(cnt)
    cnt += 1
 
for i in range(1, b+1):
    arr[i] += arr[i-1]
print(arr[b] - arr[a-1])

"""

"""
a,b = map(int,input().split())
 
arr = [0]
for i in range(46):
    for j in range(i):
        arr.append(i)
 
print(sum(arr[a:b+1]))
"""

"""
import sys

a, b = map(int, sys.stdin.readline().split())
temp = []
# 반복문을 통해 b구간까지의 수열을 만든다.
for i in range(1, b + 1):
    for j in range(i):
        temp.append(i)

# 만든 수열의 a부터 b구간까지 더한 값을 출력
print(sum(temp[a - 1:b]))
"""

"""
x, y = map(int, input().split())
a = []
for i in range(y+1) :
    for j in range(i):
        if len(a) == y :
            break
        a.append(i)
print(sum(a[x-1:y]))
"""