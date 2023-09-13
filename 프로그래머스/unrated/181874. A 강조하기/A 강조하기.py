def solution(myString):
    answer = ''
    for val in myString:
        if val != 'A':
            if val != 'a':
                answer += val.lower()
            elif val == 'a':
                answer += val.upper()
            else:
                answer += val
        else:
            answer += val
        
    return answer