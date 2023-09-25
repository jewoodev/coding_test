def solution(my_string, n):
    answer = ''
    length1 = len(my_string) - n
    for i in range(length1, len(my_string)):
        answer += my_string[i]
    return answer