def solution(str_list, ex):
    str_1 = ""
    answer = ""
    
    for str in str_list:
        if ex in str:
            continue
        else:
            answer += str

    return answer