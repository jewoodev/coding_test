def solution(order):
    answer = 0
    for ord in order:
        if ord.find("americano") != -1:
            answer += 4500
        elif ord.find("cafelatte") != -1:
            answer += 5000
        elif ord == "anything":
            answer += 4500
    return answer