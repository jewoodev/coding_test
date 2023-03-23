def solution(A, B):
    answer = 0
    for i in range(len(A)):
        if A != B:
            A = A[-1] +A[:-1]
            answer += 1
        else:
            return answer
    return -1