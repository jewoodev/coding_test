def solution(quiz):
    answer = []
    for q in quiz:
        if eval(q[:q.find("=")]) == int(q[q.find("=")+1:]):
            answer.append("O")
        else:
            answer.append("X")
    return answer