n, k = map(int, input().split()) # n은 동전의 종류, k는 만들어야 할 금액
a = []
m = 0    # 횟수

for i in range(n) :                # 동전의 종류 n개 리스트로 정렬
    a.append(int(input()))

a.reverse()   # [50000,10000,5000,1000,500,100,50,10,5,1]

for j in range(n) :
    if k - a[j] >= 0 :    
        m += k // a[j]    # k를 a[j]로 나눈 몫을 더함 
        k = k % a[j]      # k는 k를 a[j]로 나눈 나머지가 됨  
    if k == 0 : break    
        
print(m)