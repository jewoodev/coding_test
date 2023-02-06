### 첫 접근 방식 ###
"""
# import sys
# input = sys.stdin.readline

prime = []
T = int(input())

arr = list(map(int, input().split()))
for i in range(T):
    for j in range(arr[i]):
        division = []
        for k in range(1, arr[i]+1):
            if arr[j] % k == 0:
                division.append(i)
            if len(division) < 1:
                prime.append(arr[j])
print(len(prime))
"""
"""
# import sys
# input = sys.stdin.readline

prime = []
# T = int(input())

T = 4


# arr = list(map(int, input().split()))
arr = [15, 17, 18, 20]
for i in arr:
    if i > 2:
        for j in range(2, i):
            if i % j == 0:
                continue
            elif i % j != 0:
                if i not in prime: 
                    prime.append(i)   # 이렇게 하면 2에서 i-1 까지의 수 중에 나눠지는 수가 하나라도 있으면 소수로 판단해버린다.
print(len(prime))
"""
"""# import sys
# input = sys.stdin.readline

prime = []
# T = int(input())

T = 4


# arr = list(map(int, input().split()))
arr = [15, 17, 18, 20]
for i in arr:
    if i > 2:
        for j in range(2, i):
            if i % j == 0:
                break
            else:
                if i not in prime:
                    prime.append(i)    # 이렇게 해도 break 되기 전에 어떤 수라도 나뉘어지는게 있으면 추가되버린다.
print(len(prime))
"""
"""
# import sys
# input = sys.stdin.readline

prime = []
# T = int(input())
# arr = list(map(int, input().split()))
arr = [100, 300, 303, 505]

for i in arr:
    if i > 2:
        for j in range(2, i):
            if i % j == 0:
                if i in prime:
                    prime.remove(i)
                    break
            else:
                if i not in prime:
                    prime.append(i)   # 이것도 정답이 아니었다. 아마 remove가 되고 마지막 순서로 append가 되는 수가 있는 모양.
print(len(prime))
"""

### 다른 풀이 ###
"""
n = int(input())
data = list(map(int, input().split()))
count = 0

for x in data:
    for i in range(2, x+1):    # 1을 넣으면 오류가 발생할 것이다.
        if x % i == 0:
            if x == i:
                count += 1
    
        break

print(count)
"""
"""
n = int(input()) # 입력받을 숫자의 개수
nums = list(map(int, input().split(' '))) # 공백으로 숫자 구분. ex) 1 3 5 7
resCnt = 0 # 소수의 개수

for i in nums:
    cnt = 0 
    if(i == 1): # 1은 소수가 아니기 때문에 건너띔
        continue
    for j in range(2, i+1):
        if(i % j == 0):
            cnt += 1
    if(cnt == 1):
        resCnt += 1
print(resCnt)
"""


n = int(input())
numbers = map(int, input().split())
sosu = 0
for num in numbers:
    error = 0
    if num > 1 :
        for i in range(2, num):  # 2부터 n-1까지
            if num % i == 0:
                error += 1  # 2부터 n-1까지 나눈 몫이 0이면 error가 증가
        if error == 0:
            sosu += 1  # error가 없으면 소수.
print(sosu)