def solution(my_string, m, c):
    answer = ''
    num = 0
    divided_list = []
    length_to_divide = len(my_string) // m
    
    for i in range(length_to_divide - 1):
        divided_list.append(my_string[num:num+m])
        num += m
    
    left_length = len(my_string) - num
    divided_list.append(my_string[num:num+left_length])
        
    for element in divided_list:
        answer += element[c-1]
    return answer