def solution(my_str, n):
    answer = []
    k = 0
    l = k+n
    while True:
        result_1 = ""
        if l > len(my_str):
            l = len(my_str)
        for j in range(k, l):
            result_1 += my_str[j]
        if l == len(my_str):
            answer.append(result_1)
            break
        l += n
        k += n
        answer.append(result_1)
    return answer