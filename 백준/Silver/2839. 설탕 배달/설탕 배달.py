"""
# 내 풀이
n = int(input())
cnt = 0

while n > 3:
    if n % 5 != 0 & n % 3 != 0:
        if (n%10) % 3 == 0:   # 처음엔 5로 나뉘면 5로 나누기 시작해서 3으로 나누는 방식이었는데 32, 16 등 반례가 많이 생기는 방식인 것을 알고 고쳐보려다 풀지 못했다.
"""
# 다른 풀이
sugar = int(input())

bag = 0
while sugar >= 0 :                      
    if sugar % 5 == 0 :  # 5의 배수이면
        bag += (sugar // 5)  # 5로 나눈 몫을 구해야 정수가 됨
        print(bag)
        break
    sugar -= 3  
    bag += 1  # 5의 배수가 될 때까지 설탕-3, 봉지+1
else :
    print(-1)

"""
n = int(input())

if n % 5 == 0:  # 5으로 나눠떨어질 때
    print(n // 5)
else:
    p = 0
    while n > 0:
        n -= 3
        p += 1
        if n % 5 == 0:  # 3kg과 5kg를 조합해서 담을 수 있을 때
            p += n // 5
            print(p)
            break
        elif n == 1 or n == 2:  # 설탕 봉지만으로 나눌 수 없을 때
            print(-1)
            break
        elif n == 0:  # 3으로 나눠떨어질 때
            print(p)
            break
"""

"""
n = int(input()) #설탕

cnt = 0 #봉지수
while n>=0: #설탕이 남아있다면
    if n%5==0:#n이 5의 배수일 때와 0일때 실행
        cnt += (n//5) #5로 나눈 몫을 더해줌(5키로짜리 봉지)
        print(cnt)
        break
    n -= 3 #5의 배수가 될 때까지 3킬로그램짜리 봉지에 담음
    cnt += 1
else:
    print(-1) #설탕이 0이 아니라 음수가 될 경우 5,3키로로 나눌 수 없음을 의미
"""
### 이해 못한 풀이: https://myjamong.tistory.com/291
### DP 풀이: https://creamilk88.tistory.com/211
