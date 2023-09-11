def solution(myString):
    s = myString.split("x")
    answer = []
    for i in s:
        answer.append(len(i))
    return answer