def solution(array):
    for j in range(len(array)):
            array[j] = str(array[j])
    answer = 0
    for i in array:
        answer += i.count('7')
    return answer