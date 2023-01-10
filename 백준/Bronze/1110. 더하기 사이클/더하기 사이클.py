n = int(input())
num = n
cnt = 0
while True:
    a = num // 10
    b = num % 10
    c = (a+b) %10
    num = (b*10) + c
    cnt += 1
    if num==n:
        break
print(cnt)                       # int로 풀이하는 법

'''
첫번째 풀이
num = input()
count = 0
new_num = None
while int(num) != new_num:
    if len(str(num)) < 2:
        num = int(num) * 10
        multi_ten = num // 10
        one_posi = num % 10
        new_one_posi = str(multi_ten + one_posi)
        new_ten_posi = str(one_posi)
        new_num = int(new_ten_posi + new_one_posi)
        count += 1
    else:
        num = int(num)
        multi_ten = num // 10
        one_posi = num % 10
        new_one_posi = str(multi_ten + one_posi)
        new_ten_posi = str(one_posi)
        new_num = int(new_ten_posi + new_one_posi)
        count += 1
print(count)
'''


'''
정답을 보고 나서의 풀이
num = int(input())
num_wh = num
count = 0

while True:
    tens_place = num_wh // 10
    units_digit = num_wh % 10
    new_num = (tens_place + units_digit) % 10
    new_num = (units_digit * 10) + new_num
    count += 1
    if (new_num == num):
        break
print(count)
'''

'''
n = input()
num = n
cnt = 0

while 1:
    if len(num) == 1:
        num = "0" + num
    plus = str(int(num[0]) + int(num[1]))
    num = num[-1] + plus[-1]
    cnt += 1
    if num == n:
        print(cnt)
        break                                      # str로 풀이하는 법
'''

