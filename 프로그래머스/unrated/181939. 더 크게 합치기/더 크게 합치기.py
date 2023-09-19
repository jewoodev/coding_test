def solution(a, b):
    answer1 = str(a) + str(b)
    answer2 = str(b) + str(a)
    if answer1 < answer2:
        answer = answer2
    else:
        answer = answer1
    return int(answer)