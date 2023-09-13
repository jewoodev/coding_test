def solution(numLog):
    answer = ''
    length = len(numLog)
    for i in range(length-1):
        if numLog[i+1] - numLog[i] == 1:
            answer += 'w'
        elif numLog[i+1] - numLog[i] == -1:
            answer += 's'
        elif numLog[i+1] - numLog[i] == 10:
            answer += 'd'
        elif numLog[i+1] - numLog[i] == -10:
            answer += 'a'
    return answer