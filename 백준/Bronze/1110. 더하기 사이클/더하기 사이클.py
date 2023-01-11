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
        new_one_posi = str(multi_ten + one_posi)         # 새로운 수의 첫째자리수를 구하는 접근법이 아쉬웠다. 접근법뿐만 아니라 이렇게 하면 3+2=32 가
        new_ten_posi = str(one_posi)                     # 아니라 5가 되버린다. 
        new_num = int(new_ten_posi + new_one_posi)       # 수를 합하는 방법이 아쉬웠다.
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
int로 푸는 법을 보고 나서의 풀이
num = int(input())
num_wh = num
count = 0

while True:
    tens_place = num_wh // 10             
    units_digit = num_wh % 10
    new_num = (tens_place + units_digit) % 10
    new_num = (units_digit * 10) + new_num
    count += 1
    if (new_num == num):                                  # 여기까지는 좋은데 다시 while 문을 돌 때 num_wh가 바뀌지 않아서 같은 수를 재차 교체하기 때문에 break 되지 않는다.
        break                                             # 알아차리기 쉽지 않은 부분이라 이런 오류가 발생하지 않도록 절차를 섬세하게 다뤄야겠다.
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

