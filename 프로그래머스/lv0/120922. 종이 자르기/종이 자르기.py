def solution(M, N):
    answer = 0
    if M > 1:
        answer = M * N - 1
    else:
        answer += N-1
    return answer