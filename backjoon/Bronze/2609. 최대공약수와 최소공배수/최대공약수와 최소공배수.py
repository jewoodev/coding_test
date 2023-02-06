a, b = map(int, input().split())

def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

print(gcd(a, b))
print(lcm(a, b))

## 첫 접근 방식 ##
"""
biggest, smallest = map(int, input().split())
b_list = []
s_list = []
denominator = []
for i in range(1, biggest+1):
    if biggest % i == 0:
        b_list.append(i)
for i in range(1, smallest+1):
    if smallest % i == 0:
        s_list.append(i)
for i in range(len(s_list)):
    if s_list[i] in b_list:
        denominator.append(s_list[i]) 
denominator.sort()
b_deno = denominator[-1]
for i in range(len(denominator)):
    bmul = denominator[0]
    bmul *= denominator[i]
bmulti = bmul * (biggest // bmul) * (smallest // bmul)
print(b_deno)
print(bmulti)                                   # 왜 답이 안나오지..? 어?! 나왔다
"""
# 다른 풀이 - 유클리드 호제법
"""
a, b = map(int, input().split())

def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

print(gcd(a, b))
print(lcm(a, b))
"""