max_people = 0
how_many = 0

for i in range(10):
    get_out, get_in = map(int, input().split())
    how_many -= get_out
    how_many += get_in
    if max_people < how_many:
        max_people = how_many
print(max_people)

-------------------------------------------------------------------------------------------------------------------------------------

'''
다른 풀이
import sys
input =  sys.stdin.readline  # 사용 접근법이 참 좋다고 느껴진다. 응용하면 좋을 것 같다. 

result = 0                   # 최댓값
num = 0                      # 사람들의 일시적인 값

for i in range(10):
    a, b = map(int, input().split()) # 내린 사람, 탄 사람
    num -= a
    num += b
    result = max(result, num)
print(result)
'''

-------------------------------------------------------------------------------------------------------------------------------------

'''
다른 풀이 2
passenger = 0
max_passenger = 0

for _ in range(10):
    out_train, in_train  = map(int, input().split())
    passenger += in_train - out_train                   # "+=" 연산자는 우선순위가 낮아 이렇게 넣어도 뺄셈 후에 passenger에 기입하기 때문에 괜찮다.        
    max_passenger = max(passenger, max_passenger)       # 내부 함수를 이용해 최댓값을 구했다.
    
print(max_passenger)
'''

-------------------------------------------------------------------------------------------------------------------------------------

'''
다른 풀이 3                                     # 좋은 풀이법은 아닌 것 같다. 하지만 변수를 다루는 방식이 특이하다. 이렇게도 가능하구나 알게 되었다.
p = max_p = 0
for _ in range(10):
    a, b = map(int, input().split())
    if max_p < p-a+b:
        max_p = p-a+b
    p = p-a+b
print(max_p)
'''
