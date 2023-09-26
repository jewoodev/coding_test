def solution(picture, k):
    answer = []
    for pic in picture:
        element = ''
        for text in pic:
            element += text * k
        for time in range(k):
            answer.append(element)
    return answer