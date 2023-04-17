def get_middle_num(num, total):
    return total // num


def solution(num, total):
    middle_idx = num // 2
    
    middle_num = get_middle_num(num, total)
    
    start_num = middle_idx * - 1 if num % 2 == 1 else middle_idx * -1 + 1
    end_num = middle_idx + 1
    
    answer = [num + middle_num for num in range(start_num, end_num)]
    
    return answer
"""
def solution(num, total):
    num1 = total - num
    answer = []
    while True:
        num2 = 0
        for i in range(num1, num1-num, -1):  # num이 5 total이 5 인 경우 문제가 생긴다
            num2 += i
            if num2 > total:
                num1 -= 1
                break
            elif num2 == total:  # num 값만큼 수를 더하지 않아도 total과 같아지는 경우에 문제
                break            # 가 생긴다.
        if num2 == total:
            break
    for i in range(num1, num1-num, -1):
        answer.append(i)
    answer.sort()
    return answer

print(solution(3, 12))
"""