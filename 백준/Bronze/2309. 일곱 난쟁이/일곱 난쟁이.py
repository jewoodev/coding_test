# 내 풀이
import random

nine_dwarf = []

for i in range(9):
    input_dwarf = int(input())
    nine_dwarf.append(input_dwarf)
# nine_dwarf = [20, 7, 23, 19, 10, 15, 25, 8, 13]
while 1:
    sum_height = 0
    for i in range(7):
        first = nine_dwarf[random.randint(0, 8)]
        sum_height += first
        second = nine_dwarf[random.randint(0, 8)]
        sum_height += second
        third = nine_dwarf[random.randint(0, 8)]               # 이러면 같은 인덱스 번호도 randint의 출력으로 나오기 때문에 알맞지 않다.
        sum_height += third
        fourth = nine_dwarf[random.randint(0, 8)]
        sum_height += fourth
        fifth = nine_dwarf[random.randint(0, 8)]
        sum_height == fifth
        sixth = nine_dwarf[random.randint(0, 8)]
        sum_height == fifth
        seventh = nine_dwarf[random.randint(0, 8)]
        sum_height == seventh
        eighth = nine_dwarf[random.randint(0, 8)]
        sum_height == eighth
        ninth = nine_dwarf[random.randint(0, 8)]
        sum_height == eighth
        if sum_height == 100:
            nine_dwarf.sort()
            for i in range(7):
                print(nine_dwarf[i])
            break
    if sum_height == 100:
        break


"""
# 다른 풀이 - for 문
array = []
for i in range(9):
    array.append(int(input()))

array.sort()

sum_ = sum(array)

# 만약 모두다 더하고 2명을 뺐을 때 그 값이 100이라면 2개를 뺀 나머지 값들 출력
for i in range(len(array)):
    for j in range(i + 1, len(array)):
        if sum_ - array[i] - array[j] == 100:
            for k in range(len(array)):
                if k == i or k == j:
                    pass
                else:
                    print(array[k])
            exit()
"""

"""
# 다른 풀이 - combinations library
import itertools

array = [int(input()) for _ in range(9)]    # list comprehension 이용을 이렇게 하는 걸 생각해보지 못했다. 

for i in itertools.combinations(array, 7):  # 해당 배열을 7명 중복없이 뽑아준다.
    if sum(i) == 100:  # 그합이 100이라면
        for j in sorted(i):  # 그 7명을 오름차순으로 정렬후 출력한다.
            print(j)
        break #그 후 반복문 탈출

"""

"""
# 다른 풀이 - 재귀 이용
short_men = [int(input()) for _ in range(9)]
seven_short_temp = []  # 7명을 뽑아 합을 조사할 새로운 리스트 선언


def dfs(depth, start):
    if depth == 7:  # 만약 7번 재귀를 돌았다면
        if sum(seven_short_temp) == 100:  # 현재 저장된 일곱난쟁이들의 합이 100이라면
            for j in sorted(seven_short_temp):  # 오름차순으로 정렬 후 출력
                print(j)
            exit()  # 그 후 코드 종료
        else:  # 만약 7명을 뽑았는데 합이 100이 아니라면
            return  # 해당 재귀를 더이상 실행하지 않고 종료

    for i in range(start, len(short_men)):  # 시작인덱스와 9명의 난쟁이가 있으므로 9번을 돈다.
        seven_short_temp.append(short_men[i])  # 난쟁이 한명을 추가한다.
        dfs(depth + 1, i + 1)  # dfs를 돈다(다음번 깊이는 +1로 해주고 인덱스는 중복되지 않게 하기위해서 다음 인덱스를 넣어준다.)
        seven_short_temp.pop()  # dfs를 돌다 7명이 다 찼으나 합이 100이 아니어서 return 되었으면 넣었던 난쟁이 한명을 다시 빼준다.


dfs(0, 0)  # dfs를 돈다.
"""
